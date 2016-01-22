package chapter14.code.listing;

import org.apache.wicket.protocol.http.WebApplication;

public class BookCatalogApp extends WebApplication
{
    public Class<Home> getHomePage()
    {
        return Home.class;
    }
}
