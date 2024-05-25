package org.postsnet.service;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.SubscriptionDTO;
import org.postsnet.entity.Subscription;
import org.postsnet.mapper.SubscriptionMapper;
import org.postsnet.repository.SubscriptionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public Subscription create(SubscriptionDTO dto) {
        Subscription subscription = SubscriptionMapper.INSTANCE.subscriptionDTOToSubscription(dto);
        return subscriptionRepository.save(subscription);
    }

    public Page<Subscription> readAll(Pageable pageable) {
        return subscriptionRepository.findAllBy(pageable);
    }

    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }

}
