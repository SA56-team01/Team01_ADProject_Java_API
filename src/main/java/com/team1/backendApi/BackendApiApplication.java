package com.team1.backendApi;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.PlaylistSong;
import com.team1.backendApi.model.Role;
import com.team1.backendApi.model.User;
import com.team1.backendApi.repository.PlaylistRepository;
import com.team1.backendApi.repository.PlaylistSongRepository;
import com.team1.backendApi.repository.UserRepository;

@SpringBootApplication
public class BackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(UserRepository userRepository, PlaylistRepository playlistRepository, PlaylistSongRepository playlistSongRepository) {
        return (args) -> {
            // Create a user
           // User user1 = new User("spotify_user123", "US", "user@example.com", new Role("ROLE_USER"));
            User user1 = new User("spotify_user123", "US", "user@example.com", new Role("ROLE_USER"));
            userRepository.save(user1);
            //User user2 = userRepository.findById((long) 1).orElse(null);

            // Create playlists
            Playlist playlist1 = new Playlist(1L, "My Playlist 1", "2023-08-13", 12.34, 56.78, "track1,track2", 0.7, 0.8, 0.6, 0.5, 2.0, 0.7, -5.0, 1.0, 0.4, 120.0, 4.0, 0.9, "pop", user1, new ArrayList<>());
            //Playlist playlist2 = new Playlist(2L,"My Playlist 2", "2023-08-14", 23.45, 67.89, "track3,track4", 0.6, 0.7, 0.5, 0.4, 5.0, 0.8, -6.0, 0.0, 0.3, 130.0, 4.0, 0.8, "rock", user2, new ArrayList<>());
          	playlistRepository.saveAll(Arrays.asList(playlist1));

            // Create playlist songs
            PlaylistSong playlistSong1 = new PlaylistSong("101L", playlist1);
            PlaylistSong playlistSong2 = new PlaylistSong("102L", playlist1);
           // PlaylistSong playlistSong3 = new PlaylistSong(201L, playlist2);
            playlistSongRepository.saveAll(Arrays.asList(playlistSong1, playlistSong2));
        };
    }
}
