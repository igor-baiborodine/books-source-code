package com.java7developer.chapter11.listing_11_21

import java.math.BigDecimal
import java.lang.IllegalArgumentException
import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit
import org.junit.Test
import org.junit.Before
import org.junit.Assert._

  class RevenueTest extends JUnitSuite with ShouldMatchersForJUnit {
  
    var venueRevenue: TicketRevenue = _
  
    @Before def initialize() {
      venueRevenue = new TicketRevenue()
    }

    @Test def zeroSalesEqualsZeroRevenue() {
      assertEquals(BigDecimal.ZERO, venueRevenue estimateTotalRevenue 0);
    }

    @Test def failIfTooManyOrTooFewTicketsAreSold() {
      evaluating { venueRevenue.estimateTotalRevenue(-1) } should produce [IllegalArgumentException]      
      evaluating { venueRevenue.estimateTotalRevenue(101) } should produce [IllegalArgumentException]
    }

    @Test def tenTicketsSoldIsThreeHundredInRevenue() {
      val expected = new BigDecimal("300");
      assert(expected == venueRevenue.estimateTotalRevenue(10));
    }

    @Test def fiftyDiscountTickets() {
      for (i <- 1 to 50) venueRevenue.sellTicket(new Ticket())
      for (i <- 1 to 50) venueRevenue.sellTicket(new Ticket(new StubPrice(), new BigDecimal(0.9)))
      assert(1950.0 == venueRevenue.getRevenue().doubleValue());
    }
    
  }