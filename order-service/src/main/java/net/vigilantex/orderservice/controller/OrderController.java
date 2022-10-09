package net.vigilantex.orderservice.controller;

import net.vigilantex.basedomains.dto.Order;
import net.vigilantex.basedomains.dto.OrderEvent;
import net.vigilantex.orderservice.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController
{

    @Autowired
    private OrderProducer producer;
    @PostMapping("/orders")
    public String placeorder(@RequestBody Order order)
    {
        OrderEvent orderEvent=new OrderEvent();
        order.setOrderId(UUID.randomUUID().toString());
        orderEvent.setOrder(order);
        orderEvent.setMessage("first Message");
        orderEvent.setStatus("check");
        producer.sendMessage(orderEvent);
        return "delievered";
    }

}
