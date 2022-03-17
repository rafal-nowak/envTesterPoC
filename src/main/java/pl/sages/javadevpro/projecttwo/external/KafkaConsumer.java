package pl.sages.javadevpro.projecttwo.external;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.sages.javadevpro.projecttwo.domain.Task;
import pl.sages.javadevpro.projecttwo.external.env.task.TaskEnv;
import pl.sages.javadevpro.projecttwo.external.env.task.TaskEnvMapper;

import static pl.sages.javadevpro.projecttwo.config.KafkaConfiguration.TASKS_OUTBOUND_TOPIC;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = TASKS_OUTBOUND_TOPIC, groupId = "group_json",
            containerFactory = "taskKafkaListenerFactory")
    public void consumeJson(TaskEnv taskEnv) {

        System.out.println("Consumed JSON Task: " + taskEnv);

    }
}
