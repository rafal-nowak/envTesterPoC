package pl.sages.jdp.envpoc.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.sages.jdp.envpoc.model.Task;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_Task_Report_json", groupId = "group_json",
            containerFactory = "taskKafkaListenerFactory")
    public void consumeJson(Task task) {

        System.out.println("Consumed JSON Task: " + task);

    }
}
