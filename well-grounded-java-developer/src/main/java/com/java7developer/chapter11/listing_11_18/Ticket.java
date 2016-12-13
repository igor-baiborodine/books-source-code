package com.java7developer.chapter11.listing_11_18;

import java.math.BigDecimal;

// This is just an initial implementation that ensures that 
// The test class for Listing_11_18 compiles.
public class Ticket {

  public static final int BASIC_TICKET_PRICE = 30;
  private long ticketId;
  private final Price priceSource;
  private BigDecimal faceValue = null;
  private BigDecimal discountRate;

  private final class FixedPrice implements Price {
    public BigDecimal getInitialPrice() {
      return new BigDecimal(BASIC_TICKET_PRICE);
    }
  }

  public Ticket(long id) {
    ticketId = id;
    priceSource = new FixedPrice();
    discountRate = new BigDecimal("1.0");
  }

  public void setTicketId(long ticketId) {
    this.ticketId = ticketId;
  }

  public long getTicketId() {
    return ticketId;
  }

  public void setFaceValue(BigDecimal faceValue) {
    this.faceValue = faceValue;
  }

  public BigDecimal getFaceValue() {
    return faceValue;
  }

  public void setDiscountRate(BigDecimal discountRate) {
    this.discountRate = discountRate;
  }

  public BigDecimal getDiscountRate() {
    return discountRate;
  }

  public BigDecimal getDiscountPrice() {
    if (faceValue == null)
      faceValue = priceSource.getInitialPrice();
    return faceValue.multiply(discountRate);
  }
}
