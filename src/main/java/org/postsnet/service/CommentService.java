package org.postsnet.service;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.CommentDTO;
import org.postsnet.entity.Comment;
import org.postsnet.mapper.CommentMapper;
import org.postsnet.repository.CommentRepository;
import org.postsnet.repository.PostRepository;
import org.postsnet.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

//    public Comment create2(CommentDTO dto) {
//        Comment comment = CommentMapper.INSTANCE.commentDTOToComment(dto);
//        return commentRepository.save(comment);
//    }

    public Comment create(CommentDTO dto) {
        Comment parentComment = null;
        if (dto.getParentComment() != null) {
            parentComment = commentRepository.findById(dto.getParentComment())
                    .orElseThrow(() -> new IllegalArgumentException("Parent Parameter not found with id: " + dto.getParentComment()));
        }
        Comment comment = Comment.builder()
                .content(dto.getContent())
                .createdAt(dto.getCreatedAt())
                //todo можно сохранять без запроса по id
                .user(userRepository.findByUserId(dto.getUser()))
                .post(postRepository.findByPostId(dto.getPost()))
                .parentComment(parentComment)
                //.repliesComments(null)
                .build();

        return commentRepository.save(comment);
    }

    public Page<Comment> readAll(Pageable pageable) {
        return commentRepository.findAllBy(pageable);
    }

    public Page<Comment> readAllByPostId(Long id, Pageable pageable) {
        return commentRepository.findAllByPostPostId(id, pageable);
    }

    public List<Comment> readRootComments() {
        return commentRepository.findByParentCommentIsNull();
    }

    public List<Comment> readByParentCommentId(Long parentCommentId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").ascending());
        return commentRepository.findByParentComment_CommentId(parentCommentId, pageable);
    }

    public List<Comment> readAllByParentCommentId(Long id) {
        return commentRepository.findAllByParentComment_CommentId(id);
    }

    public Comment update(Comment comment) {
        return commentRepository.save(comment);
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    public Comment readById(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find order by id" + id));
    }
}
