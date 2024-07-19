package org.postsnet.service;

import lombok.RequiredArgsConstructor;
import org.postsnet.config.PasswordConfig;
import org.postsnet.dto.CredentialsDTO;
import org.postsnet.dto.SignUpDTO;
import org.postsnet.dto.UserDTO;
import org.postsnet.entity.User;
import org.postsnet.exceptions.AppException;
import org.postsnet.mapper.UserMapper;
import org.postsnet.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDTO login(CredentialsDTO credentialsDTO) {

        User user = userRepository.findByUsername(credentialsDTO.getLogin())
                .orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDTO.getPassword()),
        user.getPasswordHash())) {
            return userMapper.userToUserDTO(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDTO register(SignUpDTO signUpDTO) {
        Optional<User> optionalUser = userRepository.findByUsername(signUpDTO.getLogin());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(signUpDTO);
        user.setPasswordHash(passwordEncoder.encode(CharBuffer.wrap(signUpDTO.getPassword())));
        user.setCreatedAt(LocalDateTime.now());
        System.out.println(signUpDTO.getEmail());
        System.out.println(signUpDTO.getPassword());
        System.out.println(signUpDTO.getLogin());

        User savedUser = userRepository.save(user);

        return userMapper.userToUserDTO(savedUser);
    }

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
