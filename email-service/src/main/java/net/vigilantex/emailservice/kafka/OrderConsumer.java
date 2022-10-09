package net.vigilantex.emailservice.kafka;

import net.vigilantex.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer
{

    private static final Logger LOGGER= LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(groupId = "email",topics = "order_topics")
    public void Consumer(OrderEvent event)
    {
        LOGGER.info(String.format("EmailEvent-> %s",event.toString()));
    }


}
