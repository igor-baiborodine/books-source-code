package com.java7developer.chapter11.listing_11_10;

import java.math.BigDecimal;

// This is just an initial implementation that ensures that 
// The test class for Listing_11_10 compiles.
public class Ticket {

  private final BigDecimal price;

  public Ticket(Price price) {
    this.price = price.getInitialPrice();
  }

  public BigDecimal getDiscountPrice() {
    return BigDecimal.ZERO;
  }
}