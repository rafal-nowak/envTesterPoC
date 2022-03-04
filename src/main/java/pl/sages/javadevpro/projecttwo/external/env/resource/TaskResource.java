package pl.sages.javadevpro.projecttwo.external.env.resource;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sages.javadevpro.projecttwo.external.env.usertask.UserTaskEnv;
import pl.sages.javadevpro.projecttwo.external.env.usertask.UserTaskStatusEnv;

@AllArgsConstructor
@RestController
@RequestMapping("kafka")
public class TaskResource {

    private KafkaTemplate<String, UserTaskEnv> kafkaTemplate;

    private static final String TOPIC = "Kafka_Task_json";

    @GetMapping("/sendtask/{taskId}")
    public String post(@PathVariable("taskId") final String taskId) {

        kafkaTemplate.send(TOPIC, new UserTaskEnv(
                taskId,
                "example@gmail.com",
                "description",
                "/Users/rafalnowak/PycharmProjects/task1",
                UserTaskStatusEnv.SUBMITTED,
                "ID100"));

        return "Task Sent Successfully";
    }
}
