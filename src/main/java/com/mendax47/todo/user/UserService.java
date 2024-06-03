package com.mendax47.todo.user;

import com.mendax47.todo.exceptions.ResourceNotFound;
import com.mendax47.todo.task.Task;
import com.mendax47.todo.task.TaskRepository;
import com.mendax47.todo.user.dtos.request.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public void create(UserRequestDto userRequestDto) {
        User prepeardUser = convertUserDtoToUser(userRequestDto, null);
        userRepository.save(prepeardUser);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFound(User.class.getSimpleName()));
    }

    private User convertUserDtoToUser(UserRequestDto userRequestDto, User user) {
        Task foundTask = null;

        if (Objects.isNull(user)) {
            user = new User();
        }

        if (Objects.nonNull(userRequestDto.taskId())) {
            foundTask = taskRepository.findById(userRequestDto.taskId()).orElse(null);
        }

        Set<Task> tasks = user.getTasks();
        tasks.add(foundTask);

        user.setFirstName(userRequestDto.firstName());
        user.setLastName(userRequestDto.lastName());
        user.setEmail(userRequestDto.email());
        user.setUsername(userRequestDto.username());
        user.setPassword(userRequestDto.password());
        user.setTasks(tasks);

        return user;
    }
}