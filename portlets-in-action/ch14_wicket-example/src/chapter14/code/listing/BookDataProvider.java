package chapter14.code.listing;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.RequestCycle;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import chapter14.code.listing.servlet.BookDataObject;

public class BookDataProvider extends SortableDataProvider<Book> {
	private static final long serialVersionUID = -5359283681379230453L;

	class MyComparator implements Comparator<Book>, Serializable {
		private static final long serialVersionUID = 2897630955768482544L;

		public int compare(final Book b1, final Book b2) {
			PropertyModel<Comparable<String>> model1 = new PropertyModel<Comparable<String>>(b1, getSort().getProperty());
			PropertyModel<Comparable<String>> model2 = new PropertyModel<Comparable<String>>(b2, getSort().getProperty());

			int result = model1.getObject().compareTo((String)model2.getObject());

			if (!getSort().isAscending()) {
				result = -result;
			}

			return result;
		}
	}

	public BookDataProvider() {
		
	}
	
	public Iterator<? extends Book> iterator(int first, int count) {
		MyComparator comparator = new MyComparator();
		
		BookCatalogApp webApp = (BookCatalogApp) RequestCycle.get()
				.getApplication();
		BookDataObject data = (BookDataObject) webApp.getServletContext()
				.getAttribute("bookCatalog");
		List<Book> list = data.getBooks();
		Collections.sort(data.getBooks(), comparator);
		return list.subList(first, first + count).iterator();
	}

	public IModel<Book> model(Book object) {
		return new Model<Book>(object);
	}

	public int size() {
		BookCatalogApp webApp = (BookCatalogApp) RequestCycle.get()
				.getApplication();
		BookDataObject data = (BookDataObject) webApp.getServletContext()
				.getAttribute("bookCatalog");
		return data.getBooks().size();
	}
}
