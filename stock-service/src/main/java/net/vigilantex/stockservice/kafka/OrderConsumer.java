package net.vigilantex.stockservice.kafka;

import net.vigilantex.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {


    private static final Logger LOGGER= LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "order_topics",groupId = "stock")
    public void Consume(OrderEvent event)
    {
      LOGGER.info(String.format("Order Event-> %s",event.toString()));
    }

}
