package com.mendax47.todo.user;

import com.mendax47.todo.user.dtos.request.UserRequestDto;

import java.util.List;

public interface IUserService {
    void create(UserRequestDto userRequestDto);

    List<User> getAll();

    User getById(Long id);
}