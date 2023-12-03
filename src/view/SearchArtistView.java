package view;

import entity.artist.ArtistFull;
import interface_adapter.search_artist.*;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.awt.event.*;
import javax.swing.JTextField;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchArtistView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search artist";
    private final JTextField searchField = new JTextField(20);
    private final SearchArtistController searchArtistController;
    private final SearchArtistViewModel searchArtistViewModel;
    private final JButton searchButton;

    // Lists to display the thing
    private CustomListModel<ArtistFull> listModel;
    private final JList<ArtistFull> artistList;

    public SearchArtistView(SearchArtistController controller,
                            SearchArtistViewModel viewModel) {

        this.searchArtistController = controller;
        this.searchArtistViewModel = viewModel;

        this.searchButton = new JButton(SearchArtistViewModel.SEARCH_BUTTON_LABEL);

        searchArtistViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchArtistViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        searchField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SearchArtistState currentState = searchArtistViewModel.getState();
                        String text = searchField.getText() + e.getKeyChar();
                        currentState.setSearchInput(text);
                        searchArtistViewModel.setState(currentState);
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
                            SearchArtistState currentState = searchArtistViewModel.getState();
                            searchArtistController.execute(currentState.getSearchInput());
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

        listModel = new CustomListModel<>(searchArtistViewModel.getState().getArtists());
        artistList = new JList<>(listModel);
        artistList.setPreferredSize(new Dimension(280, 500));
        artistList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList<ArtistFull> list = (JList<ArtistFull>) e.getSource();
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
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
        List<ArtistFull> newArtists = searchArtistViewModel.getState().getArtists();
        listModel.setList(newArtists);
        listModel.fireDataChanged();
    }
}
