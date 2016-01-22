package chapter09.code.listing.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import chapter09.code.listing.domain.Book;

@Repository("bookDao")
public class JdbcBookDao implements BookDao {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Book> getBooks() {
		List<Book> books = this.jdbcTemplate.query("select * from book_tbl where active = 1",
				new BookMapper());
		return books;
	}

	public List<Book> searchBooks(String bookName, String authorName) {
		List<Book> books = this.jdbcTemplate.query(
				"select * from book_tbl  where title like '%" + bookName
						+ "%' and authors like '%" + authorName + "%' and active = 1",
				new BookMapper());
		return books;
	}

	public void addBook(final Book book) {
		this.jdbcTemplate
				.update(
						"insert into book_tbl (title, isbn_number, authors, "
								+ "created_date, created_by) values(?, ?, ?, ?, ?)",
								new PreparedStatementSetter() {
									public void setValues(PreparedStatement ps) throws SQLException {
										ps.setString(1, book.getName());
										ps.setLong(2, book.getIsbnNumber());
										ps.setString(3, book.getAuthor());
										ps.setDate(4, new java.sql.Date(book.getCreatedDate().getTime()));
										ps.setString(5, book.getCreatedBy());
									}
								}
					);
	}

	public Book getBook(Long id) {
		List<Book> books = this.jdbcTemplate.query(
				"select * from book_tbl where book_id = ?", new Object[] { id },
				new BookMapper());
		Book book = DataAccessUtils.singleResult(books);
		return book;
	}

	public boolean isUniqueISBN(Long isbnNumber) {
		boolean isUnique = false;
		List<Book> books = this.jdbcTemplate.query(
				"select * from book_tbl where isbn_number = ? and active = 1",
				new Object[] { isbnNumber }, new BookMapper());
		Book book = DataAccessUtils.singleResult(books);
		if (book == null) {
			isUnique = true;
		}
		return isUnique;
	}

	public void removeBook(Long id) {
		this.jdbcTemplate.update("update book_tbl set active = 0 where book_id = ?",
				new Object[] { id });
	}

	private static final class BookMapper implements RowMapper<Book> {
		public Book mapRow(ResultSet rs, int rowNumber) throws SQLException {
			Book book = new Book();
			book.setName(rs.getString("title"));
			book.setId(rs.getInt("book_id"));
			book.setIsbnNumber(rs.getLong("isbn_number"));
			book.setAuthor(rs.getString("authors"));
			book.setCreatedDate(rs.getDate("created_date"));
			book.setModifiedDate(rs.getDate("modified_date"));
			book.setCreatedBy(rs.getString("created_by"));
			book.setModifiedBy(rs.getString("modified_by"));
			return book;
		}
	}
}