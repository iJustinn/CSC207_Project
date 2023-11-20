package view;

import entity.album.AlbumSimple;
import interface_adapter.search_album.SearchAlbumController;
import interface_adapter.search_album.SearchAlbumState;
import interface_adapter.search_album.SearchAlbumViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search";

    private final JTextField searchField = new JTextField(20);

    private final SearchAlbumController searchAlbumController;
    private final SearchAlbumViewModel searchAlbumViewModel;

    private final JButton searchButton;
    private final JList<AlbumSimple> albumList = new JList<AlbumSimple>();
    private CustomListModel<AlbumSimple> listModel;

    public SearchView(SearchAlbumController controller, SearchAlbumViewModel viewModel) {
        this.searchAlbumController = controller;
        this.searchAlbumViewModel = viewModel;
        this.searchButton = new JButton(SearchAlbumViewModel.SEARCH_BUTTON_LABEL);

        searchAlbumViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchAlbumViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        searchField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SearchAlbumState currentState = searchAlbumViewModel.getState();
                        String text = searchField.getText() + e.getKeyChar();
                        currentState.setSearchInput(text);
                        searchAlbumViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        searchButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(searchButton)) {
                            SearchAlbumState currentState = searchAlbumViewModel.getState();
                            searchAlbumController.execute(currentState.getSearchInput());
                        }
                    }
                }
        );


        JPanel buttons = new JPanel();
        buttons.add(searchButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(searchField);
        this.add(buttons);

        albumList.setPreferredSize(new Dimension(400, 360));

        listModel = new CustomListModel<AlbumSimple>(searchAlbumViewModel.getState().getAlbums());

        albumList.setModel(listModel);

        this.add(albumList);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented yet");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        List<AlbumSimple> newAlbums = searchAlbumViewModel.getState().getAlbums();
        listModel.setList(newAlbums);
        listModel.fireDataChanged();
    }
}