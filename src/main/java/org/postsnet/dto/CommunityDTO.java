package org.postsnet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDTO {

    private String name;

    private String description;

    private LocalDateTime createdAt;

    private Long user;
}
