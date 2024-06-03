package com.mendax47.todo.user;

import com.mendax47.todo.constants.Router;
import com.mendax47.todo.user.dtos.request.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(Router.USER)
public class UserController {
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<String> create(@Validated @RequestBody UserRequestDto userRequestDto) {
        userService.create(userRequestDto);
        return ResponseEntity.ok("User has been created successfully");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping(Router.GET_BY_ID)
    public ResponseEntity<User> getById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getById(id));
    }
}