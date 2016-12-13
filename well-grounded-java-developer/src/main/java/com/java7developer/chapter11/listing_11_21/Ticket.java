package com.java7developer.chapter11.listing_11_21;

import java.math.BigDecimal;

// Refer back to chapter 5 re permgen and anonymous impls
public class Ticket {

  public static final int BASIC_TICKET_PRICE = 30;

  private final Price priceSource;
  private BigDecimal faceValue = null;
  private final BigDecimal discountRate;

  private final class FixedPrice implements Price {
    public BigDecimal getInitialPrice() {
      return new BigDecimal(BASIC_TICKET_PRICE);
    }
  }

  public Ticket() {
    priceSource = new FixedPrice();
    discountRate = new BigDecimal("1.0");
  }

  public Ticket(Price price) {
    priceSource = price;
    discountRate = new BigDecimal("1.0");
  }

  public Ticket(Price price, BigDecimal specialDiscountRate) {
    priceSource = price;
    discountRate = specialDiscountRate;
  }

  public BigDecimal getDiscountPrice() {
    if (faceValue == null)
      faceValue = priceSource.getInitialPrice();
    return faceValue.multiply(discountRate);
  }
}
