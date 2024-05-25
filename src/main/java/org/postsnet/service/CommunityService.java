package org.postsnet.service;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.CommunityDTO;
import org.postsnet.entity.Community;
import org.postsnet.mapper.CommunityMapper;
import org.postsnet.repository.CommunityRepository;
import org.postsnet.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository communityRepository;
    private final UserRepository userRepository;

    public Community create(CommunityDTO dto) {
        Community community = CommunityMapper.INSTANCE.communityDTOToCommunity(dto);
        return communityRepository.save(community);
    }

    public Page<Community> readAll(Pageable pageable) {
        return communityRepository.findAllBy(pageable);
    }

    public Community update(Community community) {
        return communityRepository.save(community);
    }

    public void delete(Long id) {
        communityRepository.deleteById(id);
    }

    public Community readById(Long id) {
        return communityRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find order by id" + id));
    }
}
