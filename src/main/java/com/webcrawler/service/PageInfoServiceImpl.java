package com.webcrawler.service;

import com.webcrawler.model.PageInfo;
import com.webcrawler.service.repos.PageInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PageInfoServiceImpl implements PageInfoService{

    private final PageInfoRepository pageInfoRepository;

    @Override
    public PageInfo savePageInfo(PageInfo pageInfo){
        return pageInfoRepository.save(pageInfo);
    }
}
