package com.egen.ecommerce.ecommerce_order_processing_service.kafka;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models.RSOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class OrderProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    public static final String TOPIC = "business.ecommerce.egen.order.v1";

    public void sendMessage(RSOrder orderEvent) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        String payload = objectMapper.writeValueAsString(orderEvent);
        LOGGER.info("sending payload='{}' to topic='{}'", payload, TOPIC);

        ListenableFutureCallback<? super SendResult<String, String>> specificCallBack = new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                    LOGGER.error("sendMessage  onFailure - Not able to send interactionEvent:", throwable);
            }

            @Override
            public void onSuccess(SendResult<String, String> stringInteractionEventSendResult) {
                RecordMetadata recordMetadata=stringInteractionEventSendResult.getRecordMetadata();
                if (recordMetadata == null) {
                    LOGGER.error("process  onSuccess recordMetadata is null " );
                } else {
                    LOGGER.info("sendMessage sendSpecificRecord onCompletion - Data sent successfully. topic = {}  offset = {} partition = {} timestamp = {}" , TOPIC, recordMetadata.offset(), recordMetadata.partition(), recordMetadata.timestamp());
                }
            }
        };
   
            ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(TOPIC, payload);
            listenableFuture.addCallback(specificCallBack);
      
    }
}
