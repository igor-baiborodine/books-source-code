package com.java7developer.chapter11.listing_11_8;

import java.math.BigDecimal;

// This is just an initial implementation that ensures that 
// The test class for Listing_11_1 compiles.
public class Ticket {

  public Ticket(String name, BigDecimal price) {
  }

  public BigDecimal getDiscountPrice() {
    return BigDecimal.ZERO;
  }
}