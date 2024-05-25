package org.postsnet.controller.v1;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.VoteDTO;
import org.postsnet.entity.Vote;
import org.postsnet.service.VoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/")
    public ResponseEntity<Vote> create(@RequestBody VoteDTO dto) {
        return ResponseEntity.ok(voteService.create(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<Vote>> readAll() {
        return ResponseEntity.ok(voteService.readAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        voteService.delete(id);
        return ResponseEntity.ok().build();
    }


}
