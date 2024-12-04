package food.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.com.entity.Orders;
import food.com.entity.Payment;
import food.com.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderService orderService;

    // Method to process payment for an existing order
    public Orders processPayment(Long orderId, Payment payment) {
        // Save payment first
        payment = paymentRepository.save(payment);

        // Now, link payment to the order and update order status
        return orderService.updatePaymentStatus(orderId, payment);  // Update order with payment status
    }

}