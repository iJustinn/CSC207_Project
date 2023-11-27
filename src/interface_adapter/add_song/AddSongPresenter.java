package interface_adapter.add_song;

import use_case.add_song.AddSongOutputBoundary;
import use_case.add_song.AddSongOutputData;

public class AddSongPresenter implements AddSongOutputBoundary{

    private AddSongViewModel addSongViewModel;

    public AddSongPresenter(AddSongViewModel addSongViewModel){
        this.addSongViewModel = addSongViewModel;
    }

    @Override
    public void prepareSuccessView(String success) {
        AddSongState state = addSongViewModel.getState();
        state.setMessage(success);
        addSongViewModel.setState(state);
        addSongViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        AddSongState state = addSongViewModel.getState();
        state.setError(error);
        addSongViewModel.firePropertyChanged();
    }
}
