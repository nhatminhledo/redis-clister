package com.example.redis.cache.constant;

public enum ReturnCode {

  SUCCESS(1),
  ERROR(2),
  INVALID_REQUEST(3),
  USER_NOT_FOUND(53),
  ERROR_ROUTE_USED(101),
  ERROR_ROUTE_FLOW_CHANGE(102),
  ERROR_ROUTE_DUPLICATE_NAME(103),
  ERROR_RESPONSE_TOKEN(201),
  PASSENGER_BAGGAGE_NOTFOUND(301),
  PASSENGER_NOTFOUND(401),
  BAD_REQUEST(400),
  ERROR_RESPONSE(500);

  private int code;

  ReturnCode(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public boolean equals(int code) {
    return this.getCode() == code;
  } 
}
