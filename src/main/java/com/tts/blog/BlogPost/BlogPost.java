package com.tts.blog.BlogPost;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class BlogPost {
    //sets ID as primary key
    @Id
    //allows the Id to be generated by the underlying database
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    private String title;
    private String author;

    @Column(length = 1000)
    private String blogEntry;

    // @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    // @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    
    // private List<Tag> tags;


    public BlogPost() {
        //non-argument constructor needed for JPA
    }
    

    public BlogPost(String title, String author, String blogEntry) {

        this.title = title;
        this.author = author;
        // this.tags = tags;
        this.blogEntry = blogEntry;
    
    }


    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // public List<Tag> getTags() {
    //     return tags;
    // }

    // public void setTags(List<Tag> tags) {
    //     this.tags = tags;
    // }

    public String getBlogEntry() {
        return this.blogEntry;
    }

    public void setBlogEntry(String blogEntry) {
        this.blogEntry = blogEntry;
    }


    @Override
    public String toString() {
        return "BlogPost [author=" + author + ", blogEntry=" + blogEntry + ", id=" + id + ", title="
                + title + "]";
    }

    

    



















}