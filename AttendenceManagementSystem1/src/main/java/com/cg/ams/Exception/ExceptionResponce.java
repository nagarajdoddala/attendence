package com.cg.ams.Exception;
import java.time.LocalDateTime;


public class ExceptionResponce {

    private int status;
    private String message;
    private LocalDateTime time;
   
    
    public ExceptionResponce() {
        super();
    }
    public ExceptionResponce(int status, String message, LocalDateTime time) {
        super();
        this.status = status;
        this.message = message;
        this.time = time;
       
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getTime() {
    	return time;
    }
    public void setTime(LocalDateTime time) {
    	this.time = time;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
 