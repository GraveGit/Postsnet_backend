package org.postsnet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.postsnet.entity.Community;
import org.postsnet.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDTO {

    private Long user;

    private Long community;
}
