package com.inq.learnease.entity.users.task;

import com.inq.learnease.dto.TaskCreateRequestDto;
import com.inq.learnease.repository.TaskRepository;
import com.inq.learnease.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class TaskCRUDTest {
    @Autowired
    private TaskRepository repository;

    private TaskService service;

    @BeforeEach
    void set() {
        this.service = new TaskService(repository);
    }

    @Test
    void Task_생성_테스트() {
        TaskCreateRequestDto dto = new TaskCreateRequestDto("test", "test", "test", "test");
        service.create(1, dto);

        assertThat(repository.findAll().size()).isEqualTo(1);
        assertThat(repository.findAll().get(0).getDate()).isEqualTo(dto.date());
        assertThat(repository.findAll().get(0).getName()).isEqualTo(dto.name());
        assertThat(repository.findAll().get(0).getTime()).isEqualTo(dto.time());
        assertThat(repository.findAll().get(0).getCategory()).isEqualTo(dto.category());
    }
}
