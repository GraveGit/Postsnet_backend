package org.postsnet.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long userId;

    private String username;

    private String email;

    private String passwordHash;

    private LocalDateTime createdAt;

    private String token;
}
