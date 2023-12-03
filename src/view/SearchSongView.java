package view;

import app.Main;

import data_access.UserDatabaseDataAccessObject;
import entity.song.Song;
import interface_adapter.add_song.AddSongController;
import interface_adapter.add_song.AddSongPresenter;
import interface_adapter.add_song.AddSongViewModel;
import interface_adapter.search_song.SearchSongController;
import interface_adapter.search_song.SearchSongState;
import interface_adapter.search_song.SearchSongViewModel;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_playlists.ViewPlaylistsPresenter;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import use_case.add_song.AddSongInteractor;
import use_case.view_playlists.ViewPlaylistsInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class SearchSongView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search song";

    private final JTextField searchField = new JTextField(20);

    private final SearchSongController searchSongController;
    private final SearchSongViewModel searchSongViewModel;

    private final JButton searchButton;

    // Lists to display the thing
    private CustomListModel<Song> listModel;
    private final JList<Song> artistList;

    public SearchSongView(SearchSongController searchSongController,
                            SearchSongViewModel searchSongViewModel) {
        this.searchSongController = searchSongController;
        this.searchSongViewModel = searchSongViewModel;

        this.searchButton = new JButton(SearchSongViewModel.SEARCH_BUTTON_LABEL);

        this.searchSongViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchSongViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        searchField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SearchSongState currentState = SearchSongView.this.searchSongViewModel.getState();
                        String text = searchField.getText() + e.getKeyChar();
                        currentState.setSearchInput(text);
                        SearchSongView.this.searchSongViewModel.setState(currentState);
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
                            SearchSongState currentState = SearchSongView.this.searchSongViewModel.getState();
                            searchSongController.execute(currentState.getSearchInput());
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

        listModel = new CustomListModel<>(this.searchSongViewModel.getState().getSongs());
        artistList = new JList<>(listModel);
        artistList.setPreferredSize(new Dimension(400, 400));
        artistList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList<Song> list = (JList<Song>) e.getSource();
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    Main.switchToAddSongView(artistList); // switch to addsongview
                }
                super.mouseClicked(e);
            }
        });

        this.add(artistList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented yet");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        List<Song> newSongs = searchSongViewModel.getState().getSongs();
        listModel.setList(newSongs);
        listModel.fireDataChanged();
    }
}
