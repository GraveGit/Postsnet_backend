package org.postsnet.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.postsnet.dto.CommunityDTO;
import org.postsnet.entity.Community;
import org.postsnet.entity.User;
import org.postsnet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CommunityMapper {

    CommunityMapper INSTANCE = Mappers.getMapper(CommunityMapper.class);
    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "user", target = "user.userId")
    })
    Community communityDTOToCommunity(CommunityDTO dto);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "user.userId", target = "user")
    })
    CommunityDTO communityToCommunityDTO(Community community);
}
