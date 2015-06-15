package com.app;


import com.vaadin.ui.Label;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SystemStatusService.class})
public class SystemStatusLayoutTest {

    private SystemStatusLayout layout;

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(SystemStatusService.class);
        Mockito.when(SystemStatusService.getValue()).thenReturn("Online");

        layout = new SystemStatusLayout();
    }

    @Test
    public void isSystemStatusShown() {
        Label lblSystemStatus = layout.getLblSystemStatus();
        String value = lblSystemStatus.getValue();

        Assert.assertEquals("Online", value);
    }
}
