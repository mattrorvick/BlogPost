package com.tts.blog.BlogPost;

public class BlogPost {
    
    private Long id;
    private String title;
    private String author;
    private String blogEntry;

    public BlogPost() {

    }
    

    public BlogPost(String title, String author, String blogEntry) {

        this.title = title;
        this.author = author;
        this.blogEntry = blogEntry;
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

    public String getBlogEntry() {
        return this.blogEntry;
    }

    public void setBlogEntry(String blogEntry) {
        this.blogEntry = blogEntry;
    }    


    @Override
    public String toString() {
        return "BlogPost {" +
            " id='" + id + "'" +
            ", title='" + title + "'" +
            ", author='" + author + "'" +
            ", blogEntry='" + blogEntry + "'" +
            "}";
    }



















}