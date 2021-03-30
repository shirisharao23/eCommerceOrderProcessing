package com.nationwide.ctm.adapter.kafka.producers;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import com.egen.ecommerce.ecommerce_order_processing_service.kafka.Producer;
import com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models.RSCustomer;
import com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models.RSOrder;
import com.nationwide.ctm.adapter.kafka.consumers.Consumer;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class OrderProducerTest {
    @Autowired
    OrderProducer orderProducer;
    @Autowired
    OrderConsumer orderUpConsumer;
    @Test
    public void testsCanWriteOrdersToKafkaTopic() throws Exception{
        RSOrder order =  new RSOrder();
        RSCustomer customer = new RSCustomer();
        customer.setFirstName("Peter");
        order.setRsCustomer(rsCustomer);
        orderProducer.sendMessage(order);
        orderUpConsumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertEquals(orderProducer.getLatch().getCount(), 0L);
        assertTrue(orderUpConsumer.getPayload().contains("Peter"));
    }



}
