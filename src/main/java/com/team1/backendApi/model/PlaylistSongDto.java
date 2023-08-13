package com.team1.backendApi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistSongDto {

    private Long id;
    private Long playlistId;

    public PlaylistSongDto() {}

    public PlaylistSongDto(Long id, Long playlistId) {
        this.id = id;
        this.playlistId = playlistId;
    }

}
