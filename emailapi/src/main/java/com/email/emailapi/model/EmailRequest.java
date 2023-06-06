package com.email.emailapi.model;

public class EmailRequest {

 
    private String  to;
    private String  Subject;
    private String  message;

    public EmailRequest(String to, String subject, String message) {
        this.to = to;
        Subject = subject;
        this.message = message;
    }

    public EmailRequest() {
    }

    public String getto() {
        return to;
    }

    public void setto(String to) {
        this.to = to;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmailRequest [to=" + to + ", Subject=" + Subject + ", message=" + message + "]";
    }

    public String getfrom() {
        return null;
    }
    
    
    
    
    
}
