package com.webcrawler.service.repos;

import com.webcrawler.model.PageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageInfoRepository extends JpaRepository<PageInfo , Long> {

}
