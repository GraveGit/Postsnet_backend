package org.postsnet.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "communities")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_id")
    private Long communityId;

    @Column(nullable = false, unique = true, name = "name")
    private String name;

    @Column(nullable = true, name = "description" )
    private String description;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
}
