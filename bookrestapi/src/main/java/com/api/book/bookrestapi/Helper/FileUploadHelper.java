package com.api.book.bookrestapi.Helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public  class FileUploadHelper {

  //  public final String UPLOAD_DIR=
    //"D:\\Spring boot projects VS\\bookrestapi\\src\\main\\resources\\static\\image";

    public final String UPLOAD_DIR=new ClassPathResource("static/image/")
    .getFile().getAbsolutePath();
    

public FileUploadHelper()  throws IOException{
    }


public boolean uploadfile(MultipartFile multipartfile)
{
    boolean f=false;

    try {
        //read data
        //  InputStream is=  multipartfile.getInputStream();
        //  byte data[]=new byte[is.available()];
        //  is.read(data);
//
        //  //write data
//
        //  FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+multipartfile.getOriginalFilename());
        //  fos.write(data);
//
        //  fos.flush();
        //  fos.close();

        // Alternative method

        Files.copy(multipartfile.getInputStream(),Paths.get(
            UPLOAD_DIR+"\\"+multipartfile.getOriginalFilename()),
        StandardCopyOption.REPLACE_EXISTING);
        f=true;




    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }

    return f;
}
    
}
