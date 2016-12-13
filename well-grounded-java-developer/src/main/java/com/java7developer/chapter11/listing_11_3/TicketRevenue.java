package com.java7developer.chapter11.listing_11_3;

import java.math.BigDecimal;

public class TicketRevenue {

  private final static int TICKET_PRICE = 30;

  public BigDecimal estimateTotalRevenue(int numberOfTicketsSold) {
    BigDecimal totalRevenue = BigDecimal.ZERO;
    if (numberOfTicketsSold == 1) {
      totalRevenue = new BigDecimal(TICKET_PRICE * numberOfTicketsSold);
    }
    return totalRevenue;
  }
}