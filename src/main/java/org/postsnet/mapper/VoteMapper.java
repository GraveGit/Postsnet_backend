package org.postsnet.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.postsnet.dto.UserDTO;
import org.postsnet.dto.VoteDTO;
import org.postsnet.entity.User;
import org.postsnet.entity.Vote;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface VoteMapper {

    VoteMapper INSTANCE = Mappers.getMapper(VoteMapper.class);

    @Mappings({
            @Mapping(source = "voteType", target = "voteType"),
            @Mapping(source = "user", target = "user.userId"),
            @Mapping(source = "post", target = "post.postId")
    })

    Vote voteDTOToVote(VoteDTO dto);

    @Mappings({
            @Mapping(source = "voteType", target = "voteType"),
            @Mapping(source = "user.userId", target = "user"),
            @Mapping(source = "post.postId", target = "post")
    })
    VoteDTO voteToVoteDTO(Vote vote);
}
