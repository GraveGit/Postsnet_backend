package org.postsnet.repository;

import org.postsnet.entity.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Page<Subscription> findAllBy(Pageable pageable);
}
