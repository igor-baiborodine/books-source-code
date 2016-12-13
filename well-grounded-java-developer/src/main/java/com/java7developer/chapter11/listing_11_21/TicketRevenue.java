package com.java7developer.chapter11.listing_11_21;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TicketRevenue {

  private final List<Ticket> ticketsSold = new ArrayList<Ticket>();

  private static final int BASIC_THEATRE_SIZE = 100;
  private final int theatreSize;

  public TicketRevenue() {
    theatreSize = BASIC_THEATRE_SIZE;
  }

  public TicketRevenue(int size) {
    theatreSize = size;
  }

  public void sellTicket(Ticket ticket) throws IllegalArgumentException {
    if (ticketsSold.size() >= theatreSize) {
      throw new IllegalArgumentException("# Tix sold must == 1.." + theatreSize);
    }
    ticketsSold.add(ticket);
  }

  // This is just a quick estimate of revenue
  public BigDecimal estimateTotalRevenue(int numberOfTicketsSold)
      throws IllegalArgumentException {
    if (numberOfTicketsSold < 0 || numberOfTicketsSold > theatreSize) {
      throw new IllegalArgumentException("# Tix sold must == 1.." + theatreSize);
    }
    return new BigDecimal(Ticket.BASIC_TICKET_PRICE * numberOfTicketsSold);
  }

  // Actually calculate the revenue
  public BigDecimal getRevenue() {
    BigDecimal out = BigDecimal.ZERO;
    for (Ticket t : ticketsSold) {
      out = out.add(t.getDiscountPrice());
    }
    return out;
  }
}