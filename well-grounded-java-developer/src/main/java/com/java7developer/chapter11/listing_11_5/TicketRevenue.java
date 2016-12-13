package com.java7developer.chapter11.listing_11_5;

import java.math.BigDecimal;

public class TicketRevenue {

  public BigDecimal estimateTotalRevenue(int numberOfTicketsSold)
      throws IllegalArgumentException {

    BigDecimal totalRevenue = null;
    if (numberOfTicketsSold < 0) {
      throw new IllegalArgumentException("Must be > -1");
    }
    if (numberOfTicketsSold == 0) {
      totalRevenue = BigDecimal.ZERO;
    }
    if (numberOfTicketsSold == 1) {
      totalRevenue = new BigDecimal("30");
    }
    if (numberOfTicketsSold == 101) {
      throw new IllegalArgumentException("Must be < 101");
    } else {
      totalRevenue = new BigDecimal(30 * numberOfTicketsSold);
    }
    return totalRevenue;
  }
}
