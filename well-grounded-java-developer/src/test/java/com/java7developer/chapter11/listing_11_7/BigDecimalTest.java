package com.java7developer.chapter11.listing_11_7;

import java.math.BigDecimal;
import org.junit.*;
import static org.junit.Assert.*;

public class BigDecimalTest {

  private BigDecimal x;

  @Before
  public void setUp() {
    x = new BigDecimal("1.5");
  }

  @After
  public void tearDown() {
    x = null;
  }

  @Test
  public void addingTwoBigDecimals() {
    assertEquals(new BigDecimal("3.0"), x.add(x));
  }

  @Test(expected = NumberFormatException.class)
  public void numberFormatExceptionIfNotANumber() {
    x = new BigDecimal("Not a number");
  }

}