package com.webcrawler.service;

import com.webcrawler.service.repos.WebSiteInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class WebSiteInfoServiceImpl implements WebSiteInfoService{

    private final WebSiteInfoRepository webSiteInfoRepository;
}
