package com.team1.backendApi.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.PlaylistDto;
import com.team1.backendApi.model.PlaylistSong;
import com.team1.backendApi.model.PlaylistSongDto;
import com.team1.backendApi.repository.PlaylistRepository;
import com.team1.backendApi.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public List<PlaylistDto> getPlaylistsByUserId(Long userId) {
        List<Playlist> playlists = playlistRepository.findByUser_UserId(userId);
        List<PlaylistDto> playlistDtos = new ArrayList<>();
        List<PlaylistSongDto> playlistSongDtos = new ArrayList<>(); // Create new Dto for playlistsongs

        for (Playlist playlist : playlists) {
            PlaylistDto playlistDto = new PlaylistDto();
            playlistDto.setId(playlist.getId());
            playlistDto.setPlaylistName(playlist.getPlaylistName());
            playlistDto.setTimestampCreated(playlist.getTimestampCreated());
            playlistDto.setLongitudeCreated(playlist.getLongitudeCreated());
            playlistDto.setLatitudeCreated(playlist.getLatitudeCreated());
            playlistDto.setSeedTracks(playlist.getSeedTracks());
            playlistDto.setTargetAcousticness(playlist.getTargetAcousticness());
            playlistDto.setTargetDanceability(playlist.getTargetDanceability());
            playlistDto.setTargetEnergy(playlist.getTargetEnergy());
            playlistDto.setTargetInstrumentalness(playlist.getTargetInstrumentalness());
            playlistDto.setTargetKey(playlist.getTargetKey());
            playlistDto.setTargetLiveness(playlist.getTargetLiveness());
            playlistDto.setTargetLoudenes(playlist.getTargetLoudenes());
            playlistDto.setTargetMode(playlist.getTargetMode());
            playlistDto.setTargetSpeechiness(playlist.getTargetSpeechiness());
            playlistDto.setTargetTempo(playlist.getTargetTempo());
            playlistDto.setTargetTimeSignature(playlist.getTargetTimeSignature());
            playlistDto.setTargetValence(playlist.getTargetValence());
            playlistDto.setType(playlist.getType());

            // List of trackIds
            List<Long> trackIds = new ArrayList<>();
            for (PlaylistSong playlistSong : playlist.getPlaylistSongs()) {
                trackIds.add(playlistSong.getId());
            }

            for (PlaylistSong playlistSong : playlist.getPlaylistSongs()) {
                trackIds.add(playlistSong.getId());

                PlaylistSongDto playlistSongDto = new PlaylistSongDto();
                playlistSongDto.setId(playlistSong.getId());
                playlistSongDto.setPlaylistId(playlist.getId()); // Set the associated playlist ID
                playlistSongDtos.add(playlistSongDto); // Add the DTO to the list
            }   
            // Add playlistSongs to playlistSongDtos
            playlistDto.setPlaylistSongs(playlistSongDtos);

            //playlistDto.setTrackIds(trackIds);

            playlistDtos.add(playlistDto);
        }

        return playlistDtos;
    }

    @Override
    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
