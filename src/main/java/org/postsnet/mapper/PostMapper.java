package org.postsnet.mapper;


import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.postsnet.dto.PostDTO;
import org.postsnet.entity.Post;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mappings({
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "content", target = "content"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "user", target = "user.userId"),
            @Mapping(source = "community", target = "community.communityId")
    })

    Post postDTOToPost(PostDTO dto);

    @Mappings({
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "content", target = "content"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "user.userId", target = "user"),
            @Mapping(source = "community.communityId", target = "community")
    })
    PostDTO postToPostDTO(Post post);
}
