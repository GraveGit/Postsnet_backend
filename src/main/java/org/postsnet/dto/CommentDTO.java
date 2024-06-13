package org.postsnet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private String content;

    private LocalDateTime createdAt;

    private Long user;

    private Long post;

    private Long parentComment;

    private List<Long> repliesComments;
}
