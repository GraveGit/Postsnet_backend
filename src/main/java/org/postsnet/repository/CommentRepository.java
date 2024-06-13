package org.postsnet.repository;

import org.postsnet.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findAllBy(Pageable pageable);

    Page<Comment> findAllByPostPostId(Long id, Pageable pageable);

    List<Comment> findAllByParentComment_CommentId(Long id);
}
