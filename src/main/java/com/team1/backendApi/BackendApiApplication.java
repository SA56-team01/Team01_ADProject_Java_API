package com.team1.backendApi;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.PlaylistSong;
import com.team1.backendApi.model.User;
import com.team1.backendApi.model.UserHistory;
import com.team1.backendApi.repository.PlaylistRepository;
import com.team1.backendApi.repository.PlaylistSongRepository;
import com.team1.backendApi.repository.UserHistoryRepository;
import com.team1.backendApi.repository.UserRepository;

@SpringBootApplication
public class BackendApiApplication {

    @Autowired
    UserRepository userRepo;
    @Autowired
    UserHistoryRepository userHistRepo;
	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(UserRepository userRepository, PlaylistRepository playlistRepository, PlaylistSongRepository playlistSongRepository) {
        return (args) -> {
            
            // Role role = new Role("ROLE_USER");
            // roleRepo.save(role);

            User user1 = new User("spotify_user123", "SG", "user@example.com");
            User user2 = new User("spotify_user456", "SG", "user2@example.com");
            userRepo.save(user1);
            userRepo.save(user2);

            UserHistory uHist1 = new UserHistory(user1, 123, 456, "track1", "2023-06-01 00:00:00");
            UserHistory uHist2 = new UserHistory(user1, 456, 789, "track2", "2023-06-01 00:00:00");
            userHistRepo.save(uHist1);
            userHistRepo.save(uHist2);
            
            // Playlist playlist1 = new Playlist(1L, "My Playlist 1", "2023-08-13", null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, user1, new ArrayList<>());
            // Playlist playlist2 = new Playlist(2L, "My Playlist 2", null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, user2, new ArrayList<>());

            // PlaylistSong song1 = new PlaylistSong("track1", playlist1);
            // PlaylistSong song2 = new PlaylistSong("track2", playlist1);
            // playlist1.getPlaylistSongs().addAll(Arrays.asList(song1, song2));

            // PlaylistSong song3 = new PlaylistSong("track3", playlist2);
            // PlaylistSong song4 = new PlaylistSong("track4", playlist2);
            // playlist2.getPlaylistSongs().addAll(Arrays.asList(song3, song4));

            // userRepository.saveAll(Arrays.asList(user1, user2));
            // playlistRepository.saveAll(Arrays.asList(playlist1, playlist2));
            // playlistSongRepository.saveAll(Arrays.asList(song1, song2, song3, song4));

        };
    }
}
