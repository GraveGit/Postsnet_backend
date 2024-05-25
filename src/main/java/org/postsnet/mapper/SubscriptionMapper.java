package org.postsnet.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.postsnet.dto.SubscriptionDTO;
import org.postsnet.entity.Subscription;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface SubscriptionMapper {

    SubscriptionMapper INSTANCE = Mappers.getMapper(SubscriptionMapper.class);

    @Mappings({
            @Mapping(source = "user", target = "user.userId"),
            @Mapping(source = "community", target = "community.communityId")
    })

    Subscription subscriptionDTOToSubscription(SubscriptionDTO dto);

    @Mappings({
            @Mapping(source = "user.userId", target = "user"),
            @Mapping(source = "community.communityId", target = "community")
    })
    SubscriptionDTO subscriptionToSubscriptionDTO(Subscription subscription);
}
