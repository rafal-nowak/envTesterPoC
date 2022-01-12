package pl.sages.jdp.envpoc.resource;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sages.jdp.envpoc.model.Task;

@AllArgsConstructor
@RestController
@RequestMapping("kafka")
public class TaskResource {

    private KafkaTemplate<String, Task> kafkaTemplate;

    private static final String TOPIC = "Kafka_Task_json";

    @GetMapping("/sendtask/{taskId}")
    public String post(@PathVariable("taskId") final String taskId) {

        kafkaTemplate.send(TOPIC, new Task(taskId, "example@gmail.com", "/Users/rafalnowak/PycharmProjects/task1", "locked"));

        return "Task Sent Successfully";
    }
}
