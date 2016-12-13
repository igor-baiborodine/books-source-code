package com.java7developer.chapter11.listing_11_12;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;

/**
 * This test is deliberately skipped in the Maven build You can run it manually
 * from within your IDE to see it fail
 */
public class TicketTest {

  @Test
  public void tenPercentDiscount() {
    Price price = new HttpPrice();
    Ticket ticket = new Ticket(price);
    assertEquals(new BigDecimal("9.0"), ticket.getDiscountPrice());
  }
}