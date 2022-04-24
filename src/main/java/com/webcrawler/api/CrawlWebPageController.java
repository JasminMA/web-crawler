package com.webcrawler.api;


import com.webcrawler.payload.request.CrawlPageRequest;
import com.webcrawler.payload.response.ApiResponse;
import com.webcrawler.business.CrawlWebPageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crawl/page")
@Api(tags = "Web Crawl API")
@Slf4j
public class CrawlWebPageController {

    private final CrawlWebPageService crawlWebPageService;


    @ApiOperation(value = "Crawl Web Page")
    @ResponseStatus(CREATED)
    @PostMapping
    public ApiResponse<Void> addDocument(@Valid @RequestBody final CrawlPageRequest crawlPageRequest) {
        crawlWebPageService.crawlPage(crawlPageRequest);
        return ApiResponse.ok(null);
    }
}
