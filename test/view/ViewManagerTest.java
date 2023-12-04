package view;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

import static org.mockito.Mockito.*;

class ViewManagerTest {

    @Mock
    private JPanel views;
    @Mock
    private CardLayout cardLayout;
    @Mock
    private ViewManagerModel viewManagerModel;

    private ViewManager viewManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewManager = new ViewManager(views, cardLayout, viewManagerModel);
    }

    @Test
    void testViewSwitchingOnPropertyChange() {
        // Simulate the property change event
        PropertyChangeEvent evt = new PropertyChangeEvent(viewManagerModel, "view", null, "NewViewName");
        viewManager.propertyChange(evt);

        // Verify that the card layout shows the correct view
        verify(cardLayout).show(views, "NewViewName");
    }
}
