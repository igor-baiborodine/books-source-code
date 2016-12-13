package com.java7developer.chapter11.listing_11_14;

import java.math.BigDecimal;

public class Ticket {
  public static final int BASIC_TICKET_PRICE = 30;
  private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.9");
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
    discountRate = DISCOUNT_RATE;
  }

  public Ticket(Price price) {
    priceSource = price;
    discountRate = DISCOUNT_RATE;
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
