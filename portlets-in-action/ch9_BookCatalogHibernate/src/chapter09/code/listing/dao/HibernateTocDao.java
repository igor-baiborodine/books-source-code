package chapter09.code.listing.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import chapter09.code.listing.domain.ToC;

@Repository("tocDao")
public class HibernateTocDao implements ToCDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void uploadToc(final ToC toc) {
		toc.setActive(1);
		sessionFactory.getCurrentSession().save(toc);
	}

	public void removeToc(long bookId) {
		String hql = "from ToC as toc where toc.active=1 and toc.book_id=" + bookId;
		ToC toc = (ToC)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		if(toc != null) {
			toc.setActive(0);
			sessionFactory.getCurrentSession().saveOrUpdate(toc);
		}
	}
}
