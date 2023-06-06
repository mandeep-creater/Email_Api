package com.api.book.bookrestapi.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.api.book.bookrestapi.Helper.FileUploadHelper;

@RestController
public class FileUpload {
    @Autowired
    private FileUploadHelper fileuploadhelper;
    
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadfile(@RequestParam("file") MultipartFile file)
    {  
       //  System.out.println(file.getOriginalFilename());
       // System.out.println(file.getSize());
       // System.out.println(file.getContentType());
       // System.out.println(file.getName());
      
try{
       if(file.isEmpty())
       {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
             .body("Request file did not contain contenet");
           
       }
       if(!file.getContentType().equals("image/jpeg"))
       {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
           .body("Only image content");
       }


         //file uploD CODE
      boolean f=  fileuploadhelper.uploadfile(file);

       if(f)
       {
                //return ResponseEntity.ok("file is succesfully uploaded");

                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/image/").path(file.getOriginalFilename()).toUriString());
       }


          

    }catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }


            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something wnet wrong");

    }
}
