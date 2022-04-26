package com.webcrawler.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cr_page_info")
@Setter
@Getter
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

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parant_page_id")
    private PageInfo parentPage;

    @OneToMany(mappedBy = "parentPage")
    private Set<PageInfo> childPages = new HashSet<>();


    public void addPageInfo(PageInfo pageInfo) {

        childPages.add(pageInfo);
    }

}
