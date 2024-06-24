package org.postsnet.repository;

import org.postsnet.entity.Community;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {

    Page<Community> findAllBy(Pageable pageable);

    Community findByCommunityId(Long id);

}
