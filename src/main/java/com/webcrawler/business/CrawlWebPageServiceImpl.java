package com.webcrawler.business;

import com.webcrawler.payload.request.CrawlPageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class CrawlWebPageServiceImpl implements CrawlWebPageService {

    @Override
    public void crawlPage(final CrawlPageRequest crawlPageRequest) {

        log.info("Current Request is {}", crawlPageRequest);

    }

}
