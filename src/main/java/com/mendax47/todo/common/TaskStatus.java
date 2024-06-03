package com.mendax47.todo.common;

import lombok.Getter;

@Getter
public enum TaskStatus {
    IN_PROGRESS((short) 0),
    COMPLETED((short) 1),
    HALT((short) 2),
    SUSPENDED((short) 3);

    private final Short value;

    TaskStatus(Short value) {
        this.value = value;
    }
}