package pl.sages.javadevpro.projecttwo.external.env.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.sages.javadevpro.projecttwo.external.env.domain.Task;

import static pl.sages.javadevpro.projecttwo.external.env.config.KafkaConfiguration.TASKS_OUTBOUND_TOPIC;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = TASKS_OUTBOUND_TOPIC, groupId = "group_json",
            containerFactory = "taskKafkaListenerFactory")
    public void consumeJson(Task task) {

        System.out.println("Consumed JSON Task: " + task);

    }
}
