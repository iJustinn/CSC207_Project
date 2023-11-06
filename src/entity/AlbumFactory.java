package entity;

import spotify.models.AlbumDto;

public interface AlbumFactory {
    Album create(String id,
                 String name,
                 String releaseDate,
                 String[] genres,
                 Artist[] artists);

    Album[] createMany(AlbumDto[] albumDtos);
}
