package com.egen.ecommerce.ecommerce_order_processing_service.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Address;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.AddressTypeEnum;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Customer;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.DeliveryMethodEnum;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Order;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.OrderDetails;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.OrderPaymentRLT;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.OrderStatusEnum;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Payment;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Product;
import com.egen.ecommerce.ecommerce_order_processing_service.database.repositories.AddressRepository;
import com.egen.ecommerce.ecommerce_order_processing_service.database.repositories.CustomerRepository;
import com.egen.ecommerce.ecommerce_order_processing_service.database.repositories.OrderRepository;
import com.egen.ecommerce.ecommerce_order_processing_service.requests.OrderRequest;
import com.egen.ecommerce.ecommerce_order_processing_service.response.PaymentResponse;
import com.egen.ecommerce.ecommerce_order_processing_service.response.ProductResponse;
import com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models.RSAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
    @Autowired
	OrderRepository orderRepo;

	@Autowired
	PaymentService paymentService;

	@Autowired
	ProductService productService;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	CustomerRepository customerRepo;

	

	private final Logger classLogger = LoggerFactory.getLogger(OrderService.class);

    public Order saveOrder(Long orderID, OrderRequest orderReq, List<PaymentResponse> transactions,
			List<ProductResponse> inventoryItems) {
				classLogger.info("Initiating database operation for create order request");				
		Address shipping_addr = getOrCreateAddressMapping(orderReq.getOrder().getBillingAddress(), AddressTypeEnum.BILLING_ADDRESS.name());
		Address billing_addr = getOrCreateAddressMapping(orderReq.getOrder().getShippingAddress(), AddressTypeEnum.SHIPPING_ADDRESS.name());

				classLogger.info("Address Saved Successfully");
		Order order = new Order();	
			// Assuming that cutsomer already exists
		Customer cutsomer = customerRepo.findCustomerByEmail(orderReq.getOrder().getRsCustomer().getEmailId());
		order.setCustomer(cutsomer);
		order.setOrderTax(orderReq.getOrder().getOrderTax());
		order.setOrderShippingCharges(orderReq.getOrder().getShippingCharges());
		order.setOrderStatus(OrderStatusEnum.ORDER_ACCEPTED.name());
		order.setOrderSubTotal(orderReq.getOrder().getSubtotal());
		order.setOrderTotal(orderReq.getOrder().getOrderTotal());
		order.setDeliveryMethod(fetchDeliveryMethod(orderReq.getOrder().getDeliveryMethod()).name());
		order.setNumberOfItems(orderReq.getOrder().getNumberOfItems());
		order.setShippAddress(shipping_addr);
		order.setBillingAddress(billing_addr);
		order = orderRepo.save(order);

		classLogger.info("Order Saved Successfully");

		
		Set<Payment> pays = new HashSet<>();
		for (PaymentResponse tran : transactions) {
			OrderPaymentRLT orderPaymentRLT = new OrderPaymentRLT();
			Payment payment = paymentService.savePayment(tran, order);
			pays.add(payment);
			orderPaymentRLT.setPayment(payment);
			orderPaymentRLT.setOrder(order);		
		}	
		classLogger.info("Payments Saved Successfully");


		
		List<Product> items = new ArrayList<>();
		for (ProductResponse itemRes : inventoryItems) {
			OrderDetails oDetails = new OrderDetails();
			Product item = productService.saveItem(itemRes, order);
			items.add(item);
			oDetails.setItem(item);
			oDetails.setOrder(order);
		}		
		classLogger.info("Items Saved Successfully");
		return order;
	}

	public Address getOrCreateAddressMapping(RSAddress addressReq, String type) {
		Address addr = null;
		if (null != addressReq && !addressReq.toString().isEmpty()) {
			if(null != addressReq.getAddressLine1() && null != addressReq.getCity()){
			Address temp = addressRepository.findByAddressLine1AndCity(addressReq.getAddressLine1(), addressReq.getCity());			
			if (null != temp)
				return temp;
			}		
		}
			addr = new Address();
			addr.setAddressLine1(addressReq.getAddressLine1());				
			addr.setCity(addressReq.getCity());
			addr.setState(addressReq.getState());
			addr.setZipcode(addressReq.getZipcode());
			addr.setAddressType(type);
			addressRepository.save(addr);
		
		return addr;
	}

	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	public Order getOrderByOrderId(Long orderID) {
		return orderRepo.findByOrderId(orderID);
	}

	public Order cancelOrder(Order order) {
		order.setOrderStatus(OrderStatusEnum.ORDER_CANCELLED.name());
		return orderRepo.save(order);
	}	

	public void cancelBulkOrder(Long orderID) {
		try {
			Order order = orderRepo.findByOrderId(orderID);
			if (null == order) {
				classLogger.error("Order Cancel failed reason='{}' for OrderID={}", "Order Not Found", orderID);
				return;
			}
			if (OrderStatusEnum.ORDER_CANCELLED.name().equals(order.getOrderStatus())) {
				classLogger.error("Order Cancel failed reason='{}' for OrderID={}", "Order cannot be updated once cancelled!",
						orderID);
				return;
			}
			cancelOrder(order);
		} catch (Exception e) {
			classLogger.debug(e.getStackTrace().toString());
			classLogger.error("Order Create failed reason='{}' for OrderID={}", "Unable to Cancel Order", orderID);
		}
	}

	public boolean validateDeliveryMethod(String delivery_method) {
		for (DeliveryMethodEnum method : DeliveryMethodEnum.values()) {
			if (method.name().equals(delivery_method)) {
				return true;
			}
		}
		return false;
	}

	public DeliveryMethodEnum fetchDeliveryMethod(String delivery_method) {
		for (DeliveryMethodEnum method : DeliveryMethodEnum.values()) {
			if (method.name().equals(delivery_method)) {
				return method;
			}
		}
		return null;
	}
}
