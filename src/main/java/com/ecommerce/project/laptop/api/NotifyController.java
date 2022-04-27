package com.ecommerce.project.laptop.api;

import com.ecommerce.project.laptop.dto.NotifyDto;
import com.ecommerce.project.laptop.dto.ReviewDto;
import com.ecommerce.project.laptop.entitty.Account;
import com.ecommerce.project.laptop.entitty.Notify;
import com.ecommerce.project.laptop.entitty.User;
import com.ecommerce.project.laptop.services.AccountService;
import com.ecommerce.project.laptop.services.AccountServiceImpl;
import com.ecommerce.project.laptop.services.NotifyServiceImpl;
import com.ecommerce.project.laptop.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/")
public class NotifyController {
    @Autowired
    private NotifyServiceImpl notifyService;
    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping(value = "/notifies")
    public ResponseEntity<List<NotifyDto>> getAll() {
        List<NotifyDto> listReviewDtos = new ArrayList<>();
        notifyService.getAllNotify().forEach(notify ->
                listReviewDtos.add(new NotifyDto(notify)));
        return new ResponseEntity<>(listReviewDtos, HttpStatus.OK);
    }

    /*

     */
    @GetMapping(value = "/notify/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") int id) {
        NotifyDto reviewDto = new NotifyDto(notifyService.getById(id));
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }
    /*

     */

    @DeleteMapping("/notify/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        if (notifyService.deleteById(id)) {
            notifyService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(false);
        }
    }
    @PostMapping(value = "/notify",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> sendNotify(@RequestParam(name = "id") long[] arrayId,@ModelAttribute(name = "notifyDto") NotifyDto notifyDto){

        String keyword=notifyDto.getKeyword();
        ResponseEntity responseEntity= null;
        List<User> list= new ArrayList<>();
        Notify notify=Notify.builder()
                .content(notifyDto.getContent())
                .checks(false)
                .keyword(notifyDto.getKeyword())
                .users(null)
                .administrator(null)
                .time(TimeUtils.getTimeNowSystem())
                .build();
            if(keyword!=null){
            responseEntity.status(HttpStatus.BAD_REQUEST).body("cant send notify by keyword is null");
            }else if(keyword.equals("ALL")){
                    notify.setUsers((Set<User>) accountService.getAllUser());
                         notifyService.saveCNotify(notify);
            }else if(keyword.equals("SELECT")){
            for (int i=0;i<arrayId.length;i++){
                Account account =accountService.getAccountById(arrayId[i]);
                list.add(account.getUser());
                notify.setUsers((Set<User>) list);
                notifyService.saveCNotify(notify);
            }

            }else if(keyword.equals("MANAGE")){

            } else {

            }
        return responseEntity;
    }

}
