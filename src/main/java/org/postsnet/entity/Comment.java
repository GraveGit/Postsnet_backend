package org.postsnet.entity;

import lombok.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(nullable = false, name = "content")
    private String content;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false, name = "post_id")
    private Post post;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = true, name = "parent_comment_id", referencedColumnName = "comment_id")
    private Comment parentComment;

//    @OneToMany(mappedBy ="parentComment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Comment> repliesComments = new ArrayList<>();
    //todo add listcomment lazy !! , jpql join fetch, join fetch limit???
}
