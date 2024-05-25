package org.postsnet.controller.v1;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.CommentDTO;
import org.postsnet.entity.Comment;
import org.postsnet.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/")
    public ResponseEntity<Comment> create(@RequestBody CommentDTO dto) {
        return ResponseEntity.ok(commentService.create(dto));
    }

    @GetMapping("/")
    public ResponseEntity<Page<Comment>> readAll(Pageable pageable) {
        Page<Comment> comments = commentService.readAll(pageable);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> readById(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.readById(id));

    }

    @PutMapping("/")
    public ResponseEntity<Comment> update(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.update(comment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.ok().build();
    }


}
