package org.postsnet.controller.v1;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.CommentDTO;
import org.postsnet.entity.Comment;
import org.postsnet.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/")
    public Comment create(@RequestBody CommentDTO dto) {
        return commentService.create(dto);
    }

    @GetMapping("/")
    public Page<Comment> readAll(Pageable pageable) {
        return commentService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public Comment readById(@PathVariable Long id) {
        return commentService.readById(id);
    }

    @GetMapping("/post/{id}")
    public Page<Comment> readByPostId(@PathVariable Long id, Pageable pageable) {
        return commentService.readAllByPostId(id, pageable);
    }

    @GetMapping("/comments/root")
    public List<Comment> readByParentCommentIdIsNull() {
        return commentService.readRootComments();
    }
    @GetMapping("/replies/{parentId}")
    public List<Comment> readByParentCommentId(@PathVariable Long parentId,
                                    @RequestParam int page,
                                    @RequestParam int size) {
        return commentService.readByParentCommentId(parentId, page, size);
    }

    @PutMapping("/")
    public Comment update(@RequestBody Comment comment) {
        return commentService.update(comment);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        commentService.delete(id);
        return "Comment successfully deleted";
    }


}
