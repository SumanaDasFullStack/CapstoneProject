package food.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import food.com.entity.Orders;
import food.com.service.OrderService;

@RestController
@RequestMapping("orders")
@CrossOrigin
public class OrderController {
	@Autowired
    private OrderService orderService;

    @PostMapping(value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Orders createOrder(@RequestBody Orders order) {
        return orderService.createOrder(order);
    }

    @GetMapping("getOrder/{id}")
    public Orders getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
}