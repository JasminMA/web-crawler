package com.webcrawler.business;

import com.webcrawler.model.PageInfo;
import com.webcrawler.payload.request.CrawlPageRequest;
import com.webcrawler.service.PageInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
class CrawlWebPageServiceImpl implements CrawlWebPageService {

    private final PageInfoService pageInfoService;

    private int counter = 1;

    @Override
    public void crawlPage(final CrawlPageRequest crawlPageRequest) {

        log.info("Current Request is {}", crawlPageRequest);
        final PageInfo pageInfo = savePages(crawlPageRequest);
        drawWebSitePages(pageInfo);
    }

    private PageInfo savePages(final CrawlPageRequest crawlPageRequest) {

        Set<String> visited = new HashSet<>();
        final String pageUrl = crawlPageRequest.getPageUrl();
        visited.add(pageUrl);

        final long start = System.currentTimeMillis();
        final int maxLevel = crawlPageRequest.getMaxLevel();
        final PageInfo pageInfo = retrievePageURLs(0, maxLevel, pageUrl, visited, null);
        final long end = System.currentTimeMillis();
        log.info("Crawling WebSite {} to level {} took ms {} s {}", pageUrl, maxLevel, (end - start), (end - start) / 1000);

        return pageInfo;
    }

    private PageInfo retrievePageURLs(int currentLevel, final int maxLevel, final String pageUrl, Set<String> visited, PageInfo parent) {

        if (currentLevel <= maxLevel) {
            final Document document = getChildPage(pageUrl);
            if (document != null) {
                PageInfo pageInfo = new PageInfo();
                pageInfo.setParentPage(parent);
                pageInfo.setTitle(document.title());
                pageInfo.setLevel(currentLevel);
                pageInfo.setPageURL(pageUrl);
                for (Element e : document.select("a[href]")) {
                    String currentUrl = e.absUrl("href");
                    currentUrl = clearCurrentURL(currentUrl);
                    log.info("{} - Current level: {} , Page URL: {}", counter++, currentLevel, pageUrl);
                    if (!visited.contains(currentUrl) && isWithinTheSameDomain(pageUrl, currentUrl)) {
                        visited.add(currentUrl);
                        final PageInfo pageInfoSub = retrievePageURLs(currentLevel + 1, maxLevel, currentUrl, visited, pageInfo);
                        pageInfo.addPageInfo(pageInfoSub);
                    }
                }
                pageInfoService.savePageInfo(pageInfo);
                return pageInfo;
            }
        }
        return parent;
    }

    private String clearCurrentURL(final String currentUrl) {

        if (currentUrl.endsWith("/#")) return currentUrl.substring(0, currentUrl.length() - 2);
        if (currentUrl.endsWith("/")) return currentUrl.substring(0, currentUrl.length() - 1);
        return currentUrl;
    }

    private boolean isWithinTheSameDomain(final String baseURL, final String currentUrl) {

        return currentUrl.startsWith(baseURL);
    }

    private Document getChildPage(final String pageUrl) {

        try {
            return Jsoup.connect(pageUrl).get();
        } catch (IOException e) {
            return null;
        }
    }

    private void drawWebSitePages(final PageInfo pageInfo) {
        //TODO to be implemented
    }

}
