package com.tts.blog.BlogPost;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BlogPostController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    private List<BlogPost> posts = new ArrayList<>();

    //localhost:8080 (/) automatically fills in

    @GetMapping(value = "/")
    public String index(BlogPost blogPost, Model model) {
        // removes all current posts inside of the arraylist called posts, from line 25
        posts.removeAll(posts);

        // this for each loop goes ove the entire repo(all blog posts), and for each one it adds them to the post arraylist
        for (BlogPost postFromDB : blogPostRepository.findAll()) {
            posts.add(postFromDB);
        }

        // this line makes the posts array list available to the webpage to be viewed
        model.addAttribute("posts", posts);
        return "blogpost/index";
    }



    @GetMapping(value = "/blogpost/new")
    public String newBlog(BlogPost blogpost) {

        return "blogpost/new";
    }
    



    @PostMapping(value = "/blogpost")
    public String addNewBlogPost(BlogPost blogPost, Model model) {


        // blogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlogEntry()));

        //old line above, springboot does the construction below
        blogPostRepository.save(blogPost);

        // posts.add(blogPost); ----- posts are removed and then added in the GetMapping above

        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        // model.addAttribute("tags", blogPost.getTags());


        return "blogpost/result";
    }



// doesn't work if it's RequestMapping...
    @PostMapping(value = "/blogpost/update/{id}")
    public String updateExistingPost(@PathVariable Long id, BlogPost blogPost, Model model) {

        Optional<BlogPost> post = blogPostRepository.findById(id);

        if(post.isPresent()) {
            BlogPost actualPost = post.get();
            actualPost.setTitle(blogPost.getTitle());
            actualPost.setAuthor(blogPost.getAuthor());
            actualPost.setBlogEntry(blogPost.getBlogEntry());

            blogPostRepository.save(actualPost);

            model.addAttribute("blogPost", actualPost);

        } else {
            return "Error";
        }

        return "blogpost/result";
    }




    @RequestMapping(value="/blogpost/{id}")
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost, Model model) {

        // takes id from URL path, passes it into deleteById from the CRUD repository

        blogPostRepository.deleteById(id);
        return "redirect:/";
    }

    



    // edit post

    @RequestMapping(value = "/blogpost/update/{id}")
    public String updateExistingPost(@PathVariable Long id, Model model) {

        //use blogPostRepo to find post by id
        //it returns an optional<T>
        //use a variable to store the blogPost if its there
        Optional<BlogPost> editPost = blogPostRepository.findById(id);


        // initialize variable to be filled by the post if it exists
        BlogPost result = null;
       
        //use optional method to check if the post came through
        if (editPost.isPresent()) {
            //if the post came through, store it in result
            result = editPost.get();
            // add attribute to page, accessible through model
            model.addAttribute("blogPost", result);

        } else {
            //need to handle error here, you could use a html error page
            return "Error";
        }
        //show browser blogpost/edit page  //////////// WAS CHANGED FROM blogpost/new to /edit
        return "blogpost/edit";
    }







}