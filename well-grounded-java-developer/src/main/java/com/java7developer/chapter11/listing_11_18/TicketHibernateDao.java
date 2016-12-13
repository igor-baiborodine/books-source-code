package com.java7developer.chapter11.listing_11_18;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

// This is just an initial implementation that ensures that 
// The test class for Listing_11_11 compiles.
public class TicketHibernateDao {

  private static SessionFactory factory;
  private static Session session;

  public TicketHibernateDao(SessionFactory factory) {
    TicketHibernateDao.factory = factory;
    TicketHibernateDao.session = getSession();
  }

  public void save(Ticket ticket) {
  }

  public Ticket findTicketById(long ticketId) {
    return null;
  }

  public void delete(Ticket ticket) {
    session.delete(ticket);
    session.flush();
  }

  private static synchronized Session getSession() {
    return factory.openSession();
  }

}