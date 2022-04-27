package com.ecommerce.project.laptop.api;

import com.ecommerce.project.laptop.dto.OrderDto;
import com.ecommerce.project.laptop.entitty.Order;
import com.ecommerce.project.laptop.services.OrderServiceImpl;
import com.ecommerce.project.laptop.utils.StringUlis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrder() {
        List<Order> orderList=orderService.getALlOrder();
        if(!orderList.isEmpty()){
            List<OrderDto> orderDtos=new ArrayList<>();
            orderList.forEach(order -> orderDtos.add(new OrderDto(order)));
            return ResponseEntity.status(HttpStatus.OK).body(orderDtos);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data ");
        }
    }

    /*

     */
    @GetMapping("/order/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable long id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return new ResponseEntity<>(new OrderDto(order), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data by request url");
        }
    }

    /*

     */
    @DeleteMapping("/order/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable long id) {
        if (orderService.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("delete success data by request url");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not found data");
        }
    }

    /*

     */
    @PostMapping(value = "/Order")
    public ResponseEntity<?> saveOrder( @ModelAttribute("OrderDto") OrderDto orderDto) {
    if(orderDto!=null){
        Order order=Order.builder()
                .sku_order(StringUlis.createSKU("SH",8))
                .orderDetails(null)
                .build();
        orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
        }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("request url invalid data ");

    }


    /*

     */
    @PutMapping(value = "/Order")
    public ResponseEntity<?> updateOrder( @ModelAttribute("OrderDto") OrderDto orderDto){
        if(orderDto!=null && orderService.existsById(orderDto.getId())){
            Order order=Order.builder()
                    .id(orderDto.getId())
                    .sku_order(StringUlis.createSKU("SH",8))
                    .orderDetails(null)
                    .build();
            orderService.saveOrder(order);
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("request url invalid data ");

    }


}
