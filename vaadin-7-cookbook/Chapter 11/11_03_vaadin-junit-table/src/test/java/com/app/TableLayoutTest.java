package com.app;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Ondrej Kvasnovsky
 */
public class TableLayoutTest {

    private TableLayout tableLayout;

    @Before
    public void setUp() throws Exception {
        tableLayout = new TableLayout();
    }

    @Test
    public void isInitializedProperly() {
        tableLayout.init();
        Component component = tableLayout.getComponent(0);
        Assert.assertTrue(component instanceof Table);
    }

    @Test
    public void areTableColumnsVisible() {
        tableLayout.init();
        Table table = tableLayout.getTable();
        Object[] visibleColumns = table.getVisibleColumns();
        Assert.assertEquals("name", visibleColumns[0]);
    }

    @Test
    public void doesTableContainItems() {
        List<User> fakeUsers = new ArrayList<User>();
        User wayneGretzky = new User("Wayne Gretzky");
        fakeUsers.add(wayneGretzky);
        User jaromirJagr = new User("Jaromir Jagr");
        fakeUsers.add(jaromirJagr);
        User sidneyCrosby = new User("Sidney Crosby");
        fakeUsers.add(sidneyCrosby);
        UserService mockedUserService = Mockito.mock(UserService.class);
        Mockito.when(mockedUserService.findAll()).thenReturn(fakeUsers);
        tableLayout.setUserService(mockedUserService);

        tableLayout.init();
        Table table = tableLayout.getTable();
        List<User> itemIds = (List<User>) table.getItemIds();

        Assert.assertEquals(3, itemIds.size());
        Assert.assertEquals(wayneGretzky, itemIds.get(0));
        Assert.assertEquals(jaromirJagr, itemIds.get(1));
        Assert.assertEquals(sidneyCrosby, itemIds.get(2));
    }
}
