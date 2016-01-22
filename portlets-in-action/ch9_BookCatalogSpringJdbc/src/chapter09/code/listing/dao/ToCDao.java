package chapter09.code.listing.dao;

import chapter09.code.listing.domain.ToC;

public interface ToCDao {
	void uploadToc(ToC toc);
	void removeToc(long book_id);
}
