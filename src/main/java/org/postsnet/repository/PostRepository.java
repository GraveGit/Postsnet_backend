package org.postsnet.repository;

import org.postsnet.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllBy(Pageable pageable);

    Post findByPostId(Long id);

}