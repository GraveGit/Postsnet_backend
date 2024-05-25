package org.postsnet.service;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.UserDTO;
import org.postsnet.entity.User;
import org.postsnet.mapper.UserMapper;
import org.postsnet.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(UserDTO dto) {
        User user = UserMapper.INSTANCE.userDTOToUser(dto);
        return userRepository.save(user);
    }

    public Page<User> readAll(Pageable pageable) {
        return userRepository.findAllBy(pageable);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User readById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find order by id" + id));
    }
}
