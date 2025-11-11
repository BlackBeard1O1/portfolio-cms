package org.mulu.pcms.mapper;

import org.mulu.pcms.dto.request.BlogRequestDTO;
import org.mulu.pcms.dto.response.BlogResponseDTO;
import org.mulu.pcms.entity.Blog;
import org.mulu.pcms.entity.User;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper {

    public Blog toEntity(BlogRequestDTO blogDto, User user) {
        if(blogDto == null)
            return null;

        Blog newBlog = new Blog();

        newBlog.setAuthor(user.getUsername());
        newBlog.setTitle(blogDto.getTitle());
        newBlog.setContent(blogDto.getContent());
        newBlog.setImageUrl(blogDto.getImage_url());
        newBlog.setUser(user);

        return newBlog;
    }

    public BlogResponseDTO toDto(Blog savedBlog) {
        if(savedBlog == null)
            return null;
        
        BlogResponseDTO blogDto = new BlogResponseDTO();
        blogDto.setId(savedBlog.getId());
        blogDto.setAuthor(savedBlog.getAuthor());
        blogDto.setTitle(savedBlog.getTitle());
        blogDto.setContent(savedBlog.getContent());
        blogDto.setImage_url(savedBlog.getImageUrl());

        return blogDto;
    }

    public Blog update(Blog existingBlog, BlogRequestDTO blog) {
        if(existingBlog == null || blog == null)
            return existingBlog;

        existingBlog.setTitle(blog.getTitle());
        existingBlog.setContent(blog.getContent());
        existingBlog.setImageUrl(blog.getImage_url());

        return existingBlog;
    }
    
}
