package com.email.emailapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Retry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.emailapi.model.EmailRequest;
import com.email.emailapi.service.EmailService;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/welcome")
    public String  welcome()
    {

        return"hello this is email  api";
    }
    
    // api to sen email
    @RequestMapping(value = "/sendemail" , method=RequestMethod.POST)
     public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
     {
          
           System.out.println(request);

           boolean result =   this.emailService.sendEmail(request.getSubject(),request.getMessage(),request.getto());

        if(result)
        {
            return ResponseEntity.ok("Email Sent Successfully.....");
        }
        else{


           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent.");
        }

     }

}
