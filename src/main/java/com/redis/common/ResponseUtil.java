package com.example.redis.cache.common;

import com.example.redis.cache.constant.ReturnCode;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

    public ResponseEntity<Response> successResponse(Object data) {
        return buildResponse(ReturnCode.SUCCESS, data, HttpStatus.OK);
      }
    
      public ResponseEntity<Response> successResponse(String message) {
        return buildCustomResponse(ReturnCode.SUCCESS, "", message, HttpStatus.OK);
      }
    
      public ResponseEntity<Response> errorResponse(ReturnCode apiStatus, String message) {
        return buildCustomResponse(apiStatus, "", message, HttpStatus.OK);
      }
    
      public ResponseEntity<Response> errorResponse(ReturnCode apiStatus, Object data, String message) {
        return buildCustomResponse(apiStatus, data, message, HttpStatus.OK);
      }
    
      public ResponseEntity<Response> errorBadRequest(ReturnCode apiStatus, Object data, String message) {
        return buildCustomResponse(apiStatus, data, message, HttpStatus.BAD_REQUEST);
      }
    
      public ResponseEntity<Response> response(ReturnCode apiStatus, Object data, String message) {
        return buildCustomResponse(apiStatus, data, message, HttpStatus.OK);
      }
    
      private Response _createResponse(ReturnCode apiStatus, Object data) {
        return new Response(apiStatus, data);
      }
    
      private ResponseEntity<Response> buildResponse(ReturnCode apiStatus, Object data, HttpStatus httpStatus) {
        return new ResponseEntity(_createResponse(apiStatus, data), httpStatus);
      }
    
      private ResponseEntity<Response> buildCustomResponse(ReturnCode apiStatus, Object data, String message, HttpStatus httpStatus) {
        return new ResponseEntity(_createCustomResponse(apiStatus, data, message), httpStatus);
      }
    
      private Response _createCustomResponse(ReturnCode apiStatus, Object data, String message) {
        return new Response(apiStatus, data, message);
      }    
}
