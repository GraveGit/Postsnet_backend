package org.postsnet.repository;

import org.postsnet.entity.Post;
import org.postsnet.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAllBy(Pageable pageable);

    User findByUserId(Long id);

    Optional<User> findByUsername(String username);
}
