package org.postsnet.controller.v1;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.PostDTO;
import org.postsnet.entity.Post;
import org.postsnet.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Post> create(@RequestBody PostDTO dto) {
        return ResponseEntity.ok(postService.create(dto));
    }

    @GetMapping("/readall")
    public ResponseEntity<Page<Post>> readAll(Pageable pageable) {
        Page<Post> posts = postService.readAll(pageable);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/readbyid/{id}")
    public ResponseEntity<Post> readById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.readById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Post> update(Post post) {
        return ResponseEntity.ok(postService.update(post));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok().build();
    }
}
