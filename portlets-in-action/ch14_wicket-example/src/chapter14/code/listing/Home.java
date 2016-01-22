package chapter14.code.listing;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class Home extends WebPage {
	public Home() {
		List<IColumn<Book>> columns = new ArrayList<IColumn<Book>>();

		columns
				.add(new PropertyColumn<Book>(new Model<String>("Name"), "name"));
		columns.add(new PropertyColumn<Book>(new Model<String>("Author"),
				"author"));
		columns.add(new PropertyColumn<Book>(new Model<String>("ISBN Number"),
				"isbnNumber"));
		SortableDataProvider<Book> sdp = new BookDataProvider();
		sdp.setSort("name", true);

		add(new AjaxFallbackDefaultDataTable<Book>("table", columns, sdp, 5));
	}		
}