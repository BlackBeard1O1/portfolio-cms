package org.mulu.pcms.repository;

import java.util.List;

import org.mulu.pcms.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByUserId(Long userId);
    
}
