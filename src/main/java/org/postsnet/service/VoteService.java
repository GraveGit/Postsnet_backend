package org.postsnet.service;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.VoteDTO;
import org.postsnet.entity.Vote;
import org.postsnet.mapper.VoteMapper;
import org.postsnet.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;

    public Vote create(VoteDTO dto) {
        Vote vote = VoteMapper.INSTANCE.voteDTOToVote(dto);
        return voteRepository.save(vote);
    }

    public List<Vote> readAll() {
        return voteRepository.findAll();
    }

    public void delete(Long id) {
        voteRepository.deleteById(id);
    }
}
