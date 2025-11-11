package org.mulu.pcms.service;

import java.util.List;

import org.mulu.pcms.dto.request.BlogRequestDTO;
import org.mulu.pcms.dto.response.BlogResponseDTO;

public interface BlogService {

    BlogResponseDTO createBlog(BlogRequestDTO blog);

    List<BlogResponseDTO> getAllBlogs();

    BlogResponseDTO getBlogById(Long id);

    List<BlogResponseDTO> getBlogsByUser(Long userId);

    BlogResponseDTO updateBlog(Long id, BlogRequestDTO blog);

    void deleteBlog(Long id);
}
