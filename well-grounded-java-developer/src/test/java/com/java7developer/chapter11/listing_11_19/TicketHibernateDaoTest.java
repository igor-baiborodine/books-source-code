package com.java7developer.chapter11.listing_11_19;

import java.math.BigDecimal;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.junit.*;
import static org.junit.Assert.*;

public class TicketHibernateDaoTest {

  private static SessionFactory factory;
  private static TicketHibernateDao ticketDao;
  private Ticket ticket;
  private Ticket ticket2;

  @BeforeClass
  public static void baseSetUp() {
    factory = new Configuration().configure().buildSessionFactory();
    ticketDao = new TicketHibernateDao(factory);
  }

  @Before
  public void setUpTest() {
    ticket = new Ticket(1);
    ticketDao.save(ticket);
    ticket2 = new Ticket(2);
    ticketDao.save(ticket2);
  }

  @Test
  public void findTicketByIdHappyPath() throws Exception {
    Ticket ticket = ticketDao.findTicketById(1);
    assertEquals(new BigDecimal("30.0"), ticket.getDiscountPrice());
  }

  @After
  public void tearDown() {
    ticketDao.delete(ticket);
    ticketDao.delete(ticket2);
  }

  @AfterClass
  public static void baseTearDown() {
    factory.close();
  }

}