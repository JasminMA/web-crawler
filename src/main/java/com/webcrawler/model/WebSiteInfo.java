package com.webcrawler.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cr_web_sit_info")
public class WebSiteInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "web_sit_info_id")
    private Set<PageInfo> pageInfos = new HashSet<>();


    public Set<PageInfo> addPageInfo(PageInfo pageInfo) {

        pageInfos.add(pageInfo);
        return pageInfos;
    }

}
