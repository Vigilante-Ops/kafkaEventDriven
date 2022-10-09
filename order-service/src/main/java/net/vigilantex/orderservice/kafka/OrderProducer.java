package net.vigilantex.orderservice.kafka;

import net.vigilantex.basedomains.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer
{
    @Autowired
    private NewTopic topic;
    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendMessage(OrderEvent event)
    {

        Message<OrderEvent> message= MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC,"order_topics").build();
        kafkaTemplate.send(message);

    }
}
