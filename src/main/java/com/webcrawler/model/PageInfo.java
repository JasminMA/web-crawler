package com.webcrawler.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cr_page_info")
@Data
public class PageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "level")
    private int level;

    @ManyToOne
    @JoinColumn(name = "web_sit_info_id", nullable = false)
    private WebSiteInfo webSiteInfo;


}
