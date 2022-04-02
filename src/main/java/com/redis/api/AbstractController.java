package com.redis.api;

import java.util.Locale;

import javax.annotation.Resource;

import com.redis.common.ResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class AbstractController {
    @Autowired
    ResponseUtil responseUtil;
    protected Logger log = LoggerFactory.getLogger(this.getClass());
  
    @Resource(name = "messageSource")
    private MessageSource messageSource;
  
    protected String getMessage(String msgKey) {
      return getMessage(msgKey, new String[]{});
    }
  
    protected String getMessage(String msgKey, String[] msgArgs) {
      return getMessage(msgKey, msgArgs, null);
    }
  
    protected String getMessage(String msgKey, String[] msgArgs, Locale locale) {
      return messageSource.getMessage(msgKey, msgArgs, null, locale);
    }
    
}
