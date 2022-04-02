package com.redis.common;

import java.io.Serializable;
import java.util.HashMap;

import com.redis.constant.ReturnCode;

import lombok.Getter;

@Getter
public class Response implements Serializable{
    private int status;
    private String message;
    private Object data; 

    public Response() {
    }
  
    public Response(ReturnCode returnCode, Object data, String message) {
      this.status = returnCode.getCode();
      this.data = data == null ? new HashMap() : data;
      this.message = message == null ? "" : message;
    }
  
    public Response(ReturnCode returnCode) {
      this.status = returnCode.getCode();
      this.data = new HashMap();
      this.message = "";
    }
  
    public Response(ReturnCode returnCode, Object data) {
      this.status = returnCode.getCode();
      this.data = data == null ? new HashMap() : data;
      this.message = "";
    }
    
}
