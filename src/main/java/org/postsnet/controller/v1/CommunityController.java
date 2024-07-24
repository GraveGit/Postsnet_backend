package org.postsnet.controller.v1;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.CommunityDTO;
import org.postsnet.entity.Community;
import org.postsnet.service.CommunityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/communities")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CommunityController {

    private final CommunityService communityService;

    @PostMapping("/")
    public ResponseEntity<Community> create(@RequestBody CommunityDTO dto) {
        return ResponseEntity.ok(communityService.create(dto));
    }

    @GetMapping("/getcom")
    public ResponseEntity<Page<Community>> readAll(Pageable pageable) {
        Page<Community> communities = communityService.readAll(pageable);
        return ResponseEntity.ok(communities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Community> readById(@PathVariable Long id) {
        return ResponseEntity.ok(communityService.readById(id));

    }

    @PutMapping("/")
    public ResponseEntity<Community> update(@RequestBody Community community) {
        return ResponseEntity.ok(communityService.update(community));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        communityService.delete(id);
        return ResponseEntity.ok().build();
    }
}
