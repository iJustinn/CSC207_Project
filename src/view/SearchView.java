package view;

import interface_adapter.search_album.SearchAlbumController;
import interface_adapter.search_album.SearchAlbumViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search";

    private final JTextField searchField = new JTextField(20);

    private final SearchAlbumController searchAlbumController;
    private final SearchAlbumViewModel searchAlbumViewModel;

    private final JButton searchButton;

    public SearchView(SearchAlbumController controller, SearchAlbumViewModel viewModel) {
        this.searchAlbumController = controller;
        this.searchAlbumViewModel = viewModel;

        searchAlbumViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchAlbumViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        searchButton = new JButton(SearchAlbumViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(searchButton);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
