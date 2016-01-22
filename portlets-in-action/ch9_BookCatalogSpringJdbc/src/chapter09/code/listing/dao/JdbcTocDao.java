package chapter09.code.listing.dao;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import chapter09.code.listing.domain.ToC;

@Repository("tocDao")
public class JdbcTocDao implements ToCDao {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	private Logger logger = Logger.getLogger(JdbcTocDao.class);
	
	public void uploadToc(final ToC toc) {
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				logger.info(toc.toString());
				PreparedStatement ps = connection.prepareStatement("insert into toc_tbl(book_id, toc_file, file_name, extension) values(?, ?, ?, ?)");
				ps.setLong(1, toc.getBook_id());
				ps.setBinaryStream(2, new ByteArrayInputStream(toc.getToc_file()), toc.getToc_file().length);
				ps.setString(3, toc.getFile_name());
				ps.setString(4, toc.getExtension());
				return ps;
			}
		});
	}

	public void removeToc(long bookId) {
		this.jdbcTemplate.update("update toc_tbl set active = 0 where book_id = ?",
				new Object[] { bookId });
		throw new RuntimeException();
	}
}
