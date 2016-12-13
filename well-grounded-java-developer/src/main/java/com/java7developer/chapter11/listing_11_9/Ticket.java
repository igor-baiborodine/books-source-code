package com.java7developer.chapter11.listing_11_9;

import java.math.BigDecimal;

public class Ticket {
  public static final int BASIC_TICKET_PRICE = 30;

  private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.9");

  private final BigDecimal price;
  private final String name;

  public Ticket(String name, BigDecimal price) {
    this.name = name;
    this.price = price;
  }

  public Ticket(String name) {
    this.name = name;
    price = new BigDecimal(BASIC_TICKET_PRICE);
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getDiscountPrice() {
    return price.multiply(DISCOUNT_RATE);
  }
}