package com.webcrawler.service.repos;

import com.webcrawler.model.WebSiteInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSiteInfoRepository extends JpaRepository<WebSiteInfo, Long> {

}
