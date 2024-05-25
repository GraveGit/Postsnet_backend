package org.postsnet.service;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.PostDTO;
import org.postsnet.entity.Post;
import org.postsnet.mapper.PostMapper;
import org.postsnet.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post create(PostDTO dto) {
        Post post = PostMapper.INSTANCE.postDTOToPost(dto);
        return postRepository.save(post);
    }

    public Page<Post> readAll(Pageable pageable) {
        return postRepository.findAllBy(pageable);
    }

    public Post update(Post post) {
        return postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public Post readById(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find order by id" + id));
    }
}
