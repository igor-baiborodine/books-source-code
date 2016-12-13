package com.java7developer.chapter11.listing_11_2;

import java.math.BigDecimal;

public class TicketRevenue {

  public BigDecimal estimateTotalRevenue(int numberOfTicketsSold) {
    BigDecimal totalRevenue = BigDecimal.ZERO;
    if (numberOfTicketsSold == 1) {
      totalRevenue = new BigDecimal("30");
    }
    return totalRevenue;
  }
}
