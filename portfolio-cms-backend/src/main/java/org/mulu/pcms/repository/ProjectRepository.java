package org.mulu.pcms.repository;

import java.util.List;

import org.mulu.pcms.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByCategoryId(Long categoryId);
    
}
