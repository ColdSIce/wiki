package com.wiki.wiki.repo;

import com.wiki.wiki.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
