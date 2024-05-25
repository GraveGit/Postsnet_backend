package org.postsnet.controller.v1;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.SubscriptionDTO;
import org.postsnet.entity.Subscription;
import org.postsnet.service.SubscriptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/")
    public ResponseEntity<Subscription> create(@RequestBody SubscriptionDTO dto) {
        return ResponseEntity.ok(subscriptionService.create(dto));
    }

    @GetMapping("/")
    public ResponseEntity<Page<Subscription>> readAll(Pageable pageable) {
        Page<Subscription> subscriptions = subscriptionService.readAll(pageable);
        return ResponseEntity.ok(subscriptions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        subscriptionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
