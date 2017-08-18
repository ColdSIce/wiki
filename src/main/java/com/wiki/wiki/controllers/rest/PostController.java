package com.wiki.wiki.controllers.rest;

import com.wiki.wiki.model.Post;
import com.wiki.wiki.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    List<Post> getAll(){
        return postRepository.findAll();
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    Post getPost(@PathVariable Long id){
        return postRepository.findOne(id);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    Post createPost(@RequestBody Post post){
        return postRepository.save(post);
    }

    @RequestMapping(value = "/post", method = RequestMethod.PUT)
    Post updatePost(@RequestBody Post post){
        return postRepository.save(post);
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Post> deletePost(@PathVariable Long id){
        Post post = postRepository.findOne(id);
        if(post != null){
            postRepository.delete(post);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
