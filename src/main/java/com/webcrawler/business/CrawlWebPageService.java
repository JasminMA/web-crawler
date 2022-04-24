package com.webcrawler.business;

import com.webcrawler.payload.request.CrawlPageRequest;

public interface CrawlWebPageService {

    void crawlPage(CrawlPageRequest crawlPageRequest);

}
