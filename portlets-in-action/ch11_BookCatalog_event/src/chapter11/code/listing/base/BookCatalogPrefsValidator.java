package chapter11.code.listing.base;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PreferencesValidator;
import javax.portlet.ValidatorException;

import chapter11.code.listing.service.BookService;

public class BookCatalogPrefsValidator implements PreferencesValidator {

	public void validate(PortletPreferences preferences)
			throws ValidatorException {
		String[] prefIsbnNumbers = preferences.getValues("prefBookISBN",
				new String[] { "-99" });
		BookService bookService = BookCatalogPortlet.getBookService();
		if (!prefIsbnNumbers[0].equalsIgnoreCase("-99")) {
			for (int i = 0; i < prefIsbnNumbers.length; i++) {
				String isbnNumber = prefIsbnNumbers[i];
				if (bookService.isUniqueISBN(Long.parseLong(isbnNumber))) {
					List<String> failedKeys = new ArrayList<String>();
					failedKeys.add("prefBookISBN");
					throw new ValidatorException("ISBN number " + isbnNumber
							+ " does not exist in the catalog", failedKeys);
				}
			}
		}
	}
}
