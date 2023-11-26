package use_case.get_by_id.get_album;

import entity.album.IAlbumFull;
import use_case.get_by_id.GetByIdDataAccessInterface;
import use_case.get_by_id.GetByIdInputBoundary;
import use_case.get_by_id.GetByIdInputData;

public class GetAlbumInteractor implements GetByIdInputBoundary {
    private final GetAlbumOutputBoundary presenter;
    private final GetByIdDataAccessInterface repository;

    public GetAlbumInteractor(GetAlbumOutputBoundary presenter,
                              GetByIdDataAccessInterface repository) {
        this.presenter = presenter;
        this.repository = repository;
    }

    @Override
    public void execute(GetByIdInputData input) {
        String id = input.getId();
        IAlbumFull album = repository.getAlbumById(id);
        GetAlbumOutputData output = new GetAlbumOutputData(album);
        presenter.success(output);
    }
}
