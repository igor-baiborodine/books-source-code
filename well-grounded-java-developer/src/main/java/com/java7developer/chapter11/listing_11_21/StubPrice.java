package com.java7developer.chapter11.listing_11_21;

import java.math.BigDecimal;

public class StubPrice implements Price {

  public BigDecimal getInitialPrice() {
    return new BigDecimal("10");
  }
}
