package com.webcrawler.business;

import com.webcrawler.model.PageInfo;
import com.webcrawler.payload.request.CrawlPageRequest;
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

    @Override
    public void crawlPage(final CrawlPageRequest crawlPageRequest) {

        log.info("Current Request is {}", crawlPageRequest);
        Set<PageInfo> pageInfoSet = new HashSet<>();

        retrievePageURLs(0, crawlPageRequest.getMaxLevel(), crawlPageRequest.getPageUrl(), pageInfoSet);

    }

    private void retrievePageURLs(int currentLevel, final int maxLevel, final String pageUrl, final Set<PageInfo> pageInfoSet) {

        if (currentLevel <= maxLevel) {
            final Document document = getChildPage(pageUrl);
            if (document != null) {
                PageInfo pageInfo = new PageInfo();
                pageInfo.setTitle(document.title());
                pageInfo.setLevel(currentLevel);
                for (Element e : document.select("a[href]")) {
                    String currentUrl = e.absUrl("href");
                    if (isWithinTheSameDomain(pageUrl, currentUrl)
                    && !currentUrl.endsWith("#")) {
                        retrievePageURLs(currentLevel++, maxLevel, currentUrl, pageInfoSet);
                    }
                }
                pageInfoSet.add(pageInfo);
                pageInfo.setChildPages(pageInfoSet);
            }
        }
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

}
