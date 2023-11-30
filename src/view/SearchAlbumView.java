package view;

import entity.album.AlbumSimple;
import interface_adapter.get_album_songs.GetSongsController;
import interface_adapter.get_album_songs.GetSongsViewModel;
import interface_adapter.search_album.SearchAlbumController;
import interface_adapter.search_album.SearchAlbumState;
import interface_adapter.search_album.SearchAlbumViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class SearchAlbumView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search";

    private final JTextField searchField = new JTextField(20);

    private final SearchAlbumController searchAlbumController;
    private final SearchAlbumViewModel searchAlbumViewModel;
    private final GetSongsController getSongsController;
    private final GetSongsViewModel getSongsViewModel;

    private final JButton searchButton;

    private CustomListModel<AlbumSimple> listModel;
    private final JList<AlbumSimple> albumList;

    public SearchAlbumView(SearchAlbumController controller,
                           SearchAlbumViewModel viewModel,
                           GetSongsController getSongsController,
                           GetSongsViewModel getSongsViewModel) {
        this.searchAlbumController = controller;
        this.searchAlbumViewModel = viewModel;
        this.getSongsController = getSongsController;
        this.getSongsViewModel = getSongsViewModel;
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

        listModel = new CustomListModel<>(searchAlbumViewModel.getState().getAlbums());
        albumList = new JList<>(listModel);
        albumList.setPreferredSize(new Dimension(400, 400));
        albumList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList<AlbumSimple> list = (JList<AlbumSimple>) e.getSource();
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    AlbumSimple album = listModel.getElementAt(index);
                    System.out.println(album.getId());
                }

                super.mouseClicked(e);
            }
        });
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
