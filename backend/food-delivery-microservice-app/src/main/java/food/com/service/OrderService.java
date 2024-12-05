package food.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.com.entity.Orders;
import food.com.entity.Payment;
import food.com.repository.OrderRepository;
import food.com.repository.PaymentRepository;

@Service
public class OrderService {
	 @Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private PaymentRepository paymentRepository;

	    // Method to create an order
	    public Orders createOrder(Orders order) {
	        // Initially, set the status to "Pending"
	        order.setStatus("Pending");
	        return orderRepository.save(order);  // Save the order
	    }

	    // Method to get an order by ID
	    public Orders getOrder(Long id) {
	        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	    }

	    // Method to update payment status in the order after payment is processed
	    public Orders updatePaymentStatus(Long orderId, Payment payment) {
	        Orders order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
	        
	        // Process payment (you can add more logic for actual payment processing)
	        payment = paymentRepository.save(payment);  // Save payment first
	        order.setPaymentId(payment.getId());
	       // order.setPayment(payment);  // Link the payment to the order

	        // Update order status to "Paid"
	        order.setStatus("Paid");

	        return orderRepository.save(order);  // Save updated order
	    }
}
