package com.ecommerce.project.laptop.api;

import com.ecommerce.project.laptop.dto.BillDto;
import com.ecommerce.project.laptop.entitty.Bill;
import com.ecommerce.project.laptop.entitty.Payment;
import com.ecommerce.project.laptop.services.BillServiceImpl;
import com.ecommerce.project.laptop.services.PaymentServiceImpl;
import com.ecommerce.project.laptop.utils.TimeUtils;
import org.jetbrains.annotations.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class BillController {

    @Autowired
    private BillServiceImpl billService;

    @Autowired
    private PaymentServiceImpl paymentService;

    @GetMapping("/bills")
    public ResponseEntity<?> getAllBill() {
        return new ResponseEntity<>(billService.getAllBill(), HttpStatus.OK);
    }

    /*

     */
    @GetMapping("/bill/{id}")
    public ResponseEntity<?> getBillById(@PathVariable long id) {
        Bill bill = billService.getBillById(id);
        if (bill != null) {
            return new ResponseEntity<>(new BillDto(bill), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data by request url");
        }
    }
    /*
     */
    @DeleteMapping("/bill/{id}")
    public ResponseEntity<?> deleteBillById(@PathVariable long id) {
        if (billService.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("delete success data by request url");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data");
        }
    }
    /*

     */
    @PostMapping(value = "/bill")
    public ResponseEntity<?> saveBill(@ModelAttribute("BillDto") BillDto billDto) {
        if (billDto != null) {
            Bill bill = Bill.builder()
                    .payDate(TimeUtils.getTimeNowSystem())
                    .totalPrice(billDto.getTotalPrice())
                    .user(null)
                    .payment(paymentService.getById(billDto.getPaymentId()))
                    .build();
            billService.saveBill(bill);
            return ResponseEntity.status(HttpStatus.OK).body("save data success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not error request url");
        }
    }

    /*

     */
    @PutMapping(value = "/bill")
    public ResponseEntity<?> updateBill(@ModelAttribute("BillDto") BillDto billDto) {
        if (billDto != null && billService.ecxitsById(billDto.getId())) {
            Bill bill = Bill.builder()
                    .payDate(TimeUtils.getTimeNowSystem())
                    .totalPrice(billDto.getTotalPrice())
                    .user(null)
                    .payment(paymentService.getById(billDto.getPaymentId()))
                    .build();
            billService.saveBill(bill);
            return ResponseEntity.status(HttpStatus.OK).body("save data success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not error request url");
        }
    }
}
