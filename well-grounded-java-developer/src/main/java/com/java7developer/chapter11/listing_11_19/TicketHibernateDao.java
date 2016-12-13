package com.java7developer.chapter11.listing_11_19;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class TicketHibernateDao {

  private static SessionFactory factory;
  private static Session session;

  public TicketHibernateDao(SessionFactory factory) {
    TicketHibernateDao.factory = factory;
    TicketHibernateDao.session = getSession();
  }

  public void save(Ticket ticket) {
    session.save(ticket);
    session.flush();
  }

  public Ticket findTicketById(long ticketId) {
    Criteria criteria = session.createCriteria(Ticket.class);
    criteria.add(Restrictions.eq("ticketId", ticketId));
    List<Ticket> tickets = criteria.list();
    return tickets.get(0);
  }

  public void delete(Ticket ticket) {
    session.delete(ticket);
    session.flush();
  }

  private static synchronized Session getSession() {
    return factory.openSession();
  }

}