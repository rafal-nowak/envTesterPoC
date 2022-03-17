package pl.sages.javadevpro.projecttwo.controller;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sages.javadevpro.projecttwo.controller.dto.TaskMapper;
import pl.sages.javadevpro.projecttwo.domain.Task;
import pl.sages.javadevpro.projecttwo.controller.dto.TaskDto;
import pl.sages.javadevpro.projecttwo.external.env.task.TaskEnv;
import pl.sages.javadevpro.projecttwo.external.env.task.TaskEnvMapper;

import static pl.sages.javadevpro.projecttwo.config.KafkaConfiguration.TASKS_INBOUND_TOPIC;

@AllArgsConstructor
@RestController
@RequestMapping("tasks")
public class TaskController {

    private KafkaTemplate<String, TaskEnv> kafkaTemplate;
    private TaskMapper taskMapper;
    private TaskEnvMapper taskEnvMapper;

    @PostMapping()
    public String sendTask(@RequestBody TaskDto taskDto) {
        Task task = taskMapper.toDomain(taskDto);

        kafkaTemplate.send(TASKS_INBOUND_TOPIC, taskEnvMapper.toDto(task));

        return "Task Sent Successfully";

    }
}
