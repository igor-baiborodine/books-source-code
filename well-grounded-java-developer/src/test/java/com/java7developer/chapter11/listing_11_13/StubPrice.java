package com.java7developer.chapter11.listing_11_13;

import java.math.BigDecimal;

public class StubPrice implements Price {

  @Override
  public BigDecimal getInitialPrice() {
    return new BigDecimal("10");
  }
}