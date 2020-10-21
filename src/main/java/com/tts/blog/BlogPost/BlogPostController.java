package com.tts.blog.BlogPost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogPostController {


    //localhost:8080 (/) automatically fills in

    @GetMapping(value = "/")
    public String index(BlogPost blogPost) {
        return "blogpost/index";
    }



}