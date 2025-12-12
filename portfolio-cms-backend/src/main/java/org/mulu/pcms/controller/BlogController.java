package org.mulu.pcms.controller;

import java.util.List;

import org.mulu.pcms.dto.request.BlogRequestDTO;
import org.mulu.pcms.dto.response.BlogResponseDTO;
import org.mulu.pcms.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/blogs")
public class BlogController {
    
    private final BlogService blogService;
    

    @PostMapping("/create")
    public ResponseEntity<BlogResponseDTO> createBlog(@RequestBody BlogRequestDTO blogRequestDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInEmail = authentication.getName();
        return ResponseEntity.ok(blogService.createBlog(blogRequestDTO, loggedInEmail));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BlogResponseDTO>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<BlogResponseDTO> getBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<BlogResponseDTO>> getBlogsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(blogService.getBlogsByUser(userId));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<BlogResponseDTO> updateBlog(@PathVariable Long id, @RequestBody BlogRequestDTO blogRequestDTO) {
        return ResponseEntity.ok(blogService.updateBlog(id, blogRequestDTO));
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }

    // @GetMapping("/latest")
    // public ResponseEntity<List<BlogResponseDTO>> getLatestBlogs() {
    //     return ResponseEntity.ok(blogService.getLatestBlogs());
    // }

    // @GetMapping("/featured")
    // public ResponseEntity<List<BlogResponseDTO>> getFeaturedBlogs() {
    //     return ResponseEntity.ok(blogService.getFeaturedBlogs());
    // }

    // @GetMapping("/trending")
    // public ResponseEntity<List<BlogResponseDTO>> getTrendingBlogs() {
    //     return ResponseEntity.ok(blogService.getTrendingBlogs());
    // }

    
}
