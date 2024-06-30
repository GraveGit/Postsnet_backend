package org.postsnet.controller.v1;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.UserDTO;
import org.postsnet.entity.Comment;
import org.postsnet.entity.User;
import org.postsnet.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.create(dto));
    }

    @GetMapping("/getall")
    public ResponseEntity<Page<User>> readAll(Pageable pageable) {
        Page<User> users = userService.readAll(pageable);
        return ResponseEntity.ok(users);
    }

    @GetMapping("readbyid/{id}")
    public ResponseEntity<User> readById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.readById(id));

    }

    @PutMapping("/")
    public ResponseEntity<User> update(User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
