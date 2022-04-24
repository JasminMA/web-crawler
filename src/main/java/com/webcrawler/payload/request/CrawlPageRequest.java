package com.webcrawler.payload.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class CrawlPageRequest {

    @NotNull
    @NotEmpty
    private String pageUrl;

    @NotNull
    @Min(1)
    private int maxLevel;

}
