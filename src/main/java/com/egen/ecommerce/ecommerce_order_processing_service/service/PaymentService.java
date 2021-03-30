package com.egen.ecommerce.ecommerce_order_processing_service.service;

import javax.transaction.Transactional;

import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Order;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.OrderPaymentRLT;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Payment;
import com.egen.ecommerce.ecommerce_order_processing_service.database.repositories.PaymentRepository;
import com.egen.ecommerce.ecommerce_order_processing_service.response.PaymentResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaymentService {    

    @Autowired
    PaymentRepository paymentRepo;

    @Autowired
    RestTemplateHelper restTemplateHelper;
    
    private final Logger classLogger = LoggerFactory.getLogger(PaymentService.class);

    public Payment savePayment(PaymentResponse paymentsData, Order order) {
		classLogger.info("Initiating database operation for payment details");		
		Payment payment = new Payment();		
		payment.setPaymentMethod(paymentsData.getRsPayment().getPaymentMethod());
		payment.setCardHolderName(paymentsData.getRsPayment().getCardholderName());
		payment.setCardNumber(paymentsData.getRsPayment().getCardNumber());
		payment.setCvv(paymentsData.getRsPayment().getCvv());
		payment.setExpiryDate(paymentsData.getRsPayment().getExpiryDate());
		payment.setZipcode(paymentsData.getRsPayment().getZipcode());

        OrderPaymentRLT orderPaymentRLT = new OrderPaymentRLT();
        orderPaymentRLT.setPayment(payment);
        orderPaymentRLT.setOrder(order);	

		return paymentRepo.save(payment);
	}	

   

}
