package org.postsnet.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.postsnet.dto.CommentDTO;
import org.postsnet.entity.Comment;

import javax.persistence.CascadeType;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

//    @Mappings({
//            @Mapping(source = "content", target = "content"),
//            @Mapping(source = "createdAt", target = "createdAt"),
//            @Mapping(source = "user", target = "user.userId"),
//            @Mapping(source = "post", target = "post.postId"),
//            @Mapping(source = "parentComment", target = "parentComment.commentId")
//    })
//
//    Comment commentDTOToComment(CommentDTO dto);
//
//    @Mappings({
//            @Mapping(source = "content", target = "content"),
//            @Mapping(source = "createdAt", target = "createdAt"),
//            @Mapping(source = "user.userId", target = "user"),
//            @Mapping(source = "post.postId", target = "post"),
//            @Mapping(source = "parentComment.commentId", target = "parentComment")
//    })
//    CommentDTO commentToCommentDTO(Comment comment);
}
