package com.me.boliplate_mvvm.service.api.vo.common;


public class CommonResponse {


    /**
     * status : true
     * message : Success.
     * responseCode : 200
     * time : 1553738474009
     */

    private int status;
    //private boolean status;
    private String message;
    private int responseCode;
    private long time;

    public boolean isStatus() {
        return true;
       // return status;
    }

    public void setStatus(boolean status) {
        this.status = 1;
        //this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
