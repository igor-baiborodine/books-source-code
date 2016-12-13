package com.java7developer.chapter11.listing_11_10;

import java.math.BigDecimal;

// This is just an initial implementation that ensures that 
// The test class for Listing_11_10 compiles.
public class HttpPrice implements Price {

  @Override
  public BigDecimal getInitialPrice() {
    return HttpPricingService.getInitialPrice();
  }

  private static class HttpPricingService {
    // Some random number is returned, in this case, 0
    static BigDecimal getInitialPrice() {
      return BigDecimal.ZERO;
    }
  }
}