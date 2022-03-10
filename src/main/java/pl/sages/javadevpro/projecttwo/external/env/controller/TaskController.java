package pl.sages.javadevpro.projecttwo.external.env.controller;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sages.javadevpro.projecttwo.external.env.controller.dto.TaskDto;
import pl.sages.javadevpro.projecttwo.external.env.controller.dto.TaskMapper;
import pl.sages.javadevpro.projecttwo.external.env.domain.Task;

import static pl.sages.javadevpro.projecttwo.external.env.config.KafkaConfiguration.TASKS_INBOUND_TOPIC;

@AllArgsConstructor
@RestController
@RequestMapping("tasks")
public class TaskController {

    private KafkaTemplate<String, Task> kafkaTemplate;
    private TaskMapper taskMapper;

    @PostMapping()
    public String sendTask(@RequestBody TaskDto taskDto) {
        Task task = taskMapper.toDomain(taskDto);

        kafkaTemplate.send(TASKS_INBOUND_TOPIC, task);

        return "Task Sent Successfully";

    }
}
