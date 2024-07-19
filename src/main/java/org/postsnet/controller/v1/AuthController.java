package org.postsnet.controller.v1;

import lombok.RequiredArgsConstructor;
import org.postsnet.config.UserAuthProvider;
import org.postsnet.dto.CredentialsDTO;
import org.postsnet.dto.SignUpDTO;
import org.postsnet.dto.UserDTO;
import org.postsnet.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody CredentialsDTO credentialsDTO) {
        UserDTO user = userService.login(credentialsDTO);
        user.setToken(userAuthProvider.crateToken(user));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> login(@RequestBody SignUpDTO signUpDTO) {
        UserDTO user = userService.register(signUpDTO);
        user.setToken(userAuthProvider.crateToken(user));
        return ResponseEntity.created(URI.create("/users/" + user.getUserId())).body(user);
    }


    @GetMapping("/messages")
    public ResponseEntity<List<String>> messages() {
        return ResponseEntity.ok(Arrays.asList("first", "second"));
    }

}
