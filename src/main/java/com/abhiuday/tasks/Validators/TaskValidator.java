package com.abhiuday.tasks.Validators;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;

import com.abhiuday.tasks.Exceptions.Exception;
import com.abhiuday.tasks.Exceptions.TaskNotValidException;
import com.abhiuday.tasks.Models.Task;

public class TaskValidator {

    private static final List<String> ALLOWED_PRIORITIES = Arrays.asList("LOW", "MEDIUM", "HIGH");


    public static void validate(Task task) {
        if (!StringUtils.hasText(task.getTitle())) {
            throw new TaskNotValidException(Exception.NO_TITLE.getMessage());
        }

        if (task.getTitle().length() > 100) {
            throw new TaskNotValidException(Exception.TITLE_LENGTH_EXCEEDED.getMessage());
        }

        if (task.getDueDate() != null && task.getDueDate().isBefore(LocalDate.now())) {
            throw new TaskNotValidException(Exception.DUE_DATE_IN_PAST.getMessage());
        }

        if (task.getPriority() != null && !ALLOWED_PRIORITIES.contains(task.getPriority().toUpperCase())) {
            throw new TaskNotValidException(Exception.INVAILD_PRIORITY.getMessage());
        }
    }
}