package org.mulu.pcms.service.impl;

import java.util.List;

import org.mulu.pcms.dto.request.BlogRequestDTO;
import org.mulu.pcms.dto.response.BlogResponseDTO;
import org.mulu.pcms.entity.Blog;
import org.mulu.pcms.entity.User;
import org.mulu.pcms.mapper.BlogMapper;
import org.mulu.pcms.mapper.UserMapper;
import org.mulu.pcms.repository.BlogRepository;
import org.mulu.pcms.repository.UserRepository;
import org.mulu.pcms.service.BlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;
    private final UserRepository userRepository;

    public BlogServiceImpl(BlogRepository blogRepository, BlogMapper blogMapper, UserServiceImpl userService,
            UserMapper userMapper, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
        this.userRepository = userRepository;
    }

    @Override
    public BlogResponseDTO createBlog(BlogRequestDTO blog, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Blog newBlog = blogMapper.toEntity(blog, user);

        Blog savedBlog = blogRepository.save(newBlog);

        return blogMapper.toDto(savedBlog);
    }

    @Override
    public List<BlogResponseDTO> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.stream()
                .map(blogMapper::toDto)
                .toList();
    }

    @Override
    public BlogResponseDTO getBlogById(Long id) {
        Blog existingBlog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));

        return blogMapper.toDto(existingBlog);
    }

    @Override
    public List<BlogResponseDTO> getBlogsByUser(Long userId) {
        List<Blog> userBlogs = blogRepository.findByUserId(userId);

        return userBlogs.stream()
                .map(blogMapper::toDto)
                .toList();
    }

    @Override
    public BlogResponseDTO updateBlog(Long id, BlogRequestDTO blog) {
        if (!blogRepository.existsById(id))
            return null;

        Blog existingBlog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not find Blog by this id"));

        Blog updatedBlog = blogMapper.update(existingBlog, blog);

        Blog savedBlog = blogRepository.save(updatedBlog);

        return blogMapper.toDto(savedBlog);

    }

    @Override
    public void deleteBlog(Long id) {
        if (!blogRepository.existsById(id))
            throw new RuntimeException("Blog not found");

        blogRepository.deleteById(id);
    }

}
