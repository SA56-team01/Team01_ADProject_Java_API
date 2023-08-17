package com.team1.backendApi;

import com.team1.backendApi.config.CorsConfig;
import com.team1.backendApi.model.Admin;
import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.PlaylistSong;
import com.team1.backendApi.model.User;
import com.team1.backendApi.repository.AdminRepository;
import com.team1.backendApi.repository.PlaylistRepository;
import com.team1.backendApi.repository.PlaylistSongRepository;
import com.team1.backendApi.repository.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

@Import(CorsConfig.class)
@SpringBootApplication
public class BackendApiApplication {

  @Autowired
  AdminRepository adminRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  PlaylistRepository playlistRepository;

  @Autowired
  PlaylistSongRepository playlistSongRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public static void main(String[] args) {
    SpringApplication.run(BackendApiApplication.class, args);
  }

  @Bean
  CommandLineRunner runner() {
    return args -> {
      // Create a new admin
      Admin admin = new Admin();
      admin.setUsername("admin2");
      admin.setPassword(passwordEncoder.encode("secretpassword"));

      // Save the admin with hashed password
      adminRepository.save(admin);

      User user1 = new User(
        "31yi3mwekgnigzuk5ynbzwrhwm34",
        "SG",
        "user2@example.com"
      );
      User user2 = new User("user2", "SG", "user2@example.com");
      User user3 = new User("user3", "SG", "user3@example.com");
      User user4 = new User("user4", "SG", "user4@example.com");
      User user5 = new User("user5", "SG", "user5@example.com");
      User user6 = new User("user6", "SG", "user6@example.com");
      User user7 = new User("user7", "SG", "user7@example.com");
      User user8 = new User("user8", "SG", "user8@example.com");
      User user9 = new User("user9", "SG", "user9@example.com");
      User user10 = new User("user10", "SG", "user10@example.com");

      userRepository.saveAndFlush(user1);
      userRepository.saveAndFlush(user2);
      userRepository.saveAndFlush(user3);
      userRepository.saveAndFlush(user4);
      userRepository.saveAndFlush(user5);
      userRepository.saveAndFlush(user6);
      userRepository.saveAndFlush(user7);
      userRepository.saveAndFlush(user8);
      userRepository.saveAndFlush(user9);
      userRepository.saveAndFlush(user10);

      //   List<String> musicTypes = List.of(
      //     "pop",
      //     "rock",
      //     "hip-hop",
      //     "electronic",
      //     "indie"
      //   );
      Random random = new Random();

      List<User> users = userRepository.findAll().subList(0, 10);

      for (int i = 1; i <= 100; i++) {
        String playlistName = "Playlist " + i;
        String spotifyPlaylistId = "spotifyPlaylistId" + i;
        String timestamp = "2023-08-" + (14 + i % 7); // Generating a random date between 2023-08-14 and 2023-08-20
        double longitude = 101.333 + (104.412 - 101.333) * random.nextDouble();
        double latitude = 1.083 + (4.0 - 1.083) * random.nextDouble();
        String seedTracks = "t" + i;
        double targetAcousticness = random.nextDouble();
        double targetDanceability = random.nextDouble();
        double targetEnergy = random.nextDouble();
        double targetInstrumentalness = random.nextDouble();
        double targetKey = random.nextDouble();
        double targetLiveness = random.nextDouble();
        double targetLoudness = random.nextDouble();
        double targetMode = random.nextDouble();
        double targetSpeechiness = random.nextDouble();
        double targetTempo = random.nextDouble();
        double targetTimeSignature = random.nextDouble();
        double targetValence = random.nextDouble();
        String type = "MOCK";
        User user = users.get(i % 10);

        Playlist playlist = new Playlist(
          playlistName,
          spotifyPlaylistId,
          timestamp,
          longitude,
          latitude,
          seedTracks,
          targetAcousticness,
          targetDanceability,
          targetEnergy,
          targetInstrumentalness,
          targetKey,
          targetLiveness,
          targetLoudness,
          targetMode,
          targetSpeechiness,
          targetTempo,
          targetTimeSignature,
          targetValence,
          type,
          user,
          new ArrayList<>()
        );

        playlistRepository.save(playlist);

        for (int j = 1; j <= 3; j++) { // Creating 3 playlist songs for each playlist
          PlaylistSong playlistSong = new PlaylistSong("track" + j, playlist);
          playlist.getPlaylistSongs().add(playlistSong);
          playlistSongRepository.save(playlistSong);
        }

        playlistRepository.save(playlist);
      }
    };
    //   //mock playlists
    //   Playlist playlist1 = new Playlist(
    //     "Playlist 1",
    //     "spotifyPlaylistId1",
    //     "2023-08-14",
    //     2.5,
    //     1.5,
    //     "t1",
    //     1.1,
    //     2.2,
    //     3.3,
    //     4.4,
    //     5.5,
    //     6.6,
    //     7.7,
    //     8.8,
    //     9.9,
    //     10.1,
    //     11.1,
    //     12.1,
    //     "pop",
    //     user1,
    //     new ArrayList<>()
    //   );

    //   Playlist playlist2 = new Playlist(
    //     "Playlist 2",
    //     "spotifyPlaylistId2",
    //     "2023-08-15",
    //     3.0,
    //     2.0,
    //     "t2",
    //     1.2,
    //     2.3,
    //     3.4,
    //     4.5,
    //     5.6,
    //     6.7,
    //     7.8,
    //     8.9,
    //     9.0,
    //     10.2,
    //     11.2,
    //     12.2,
    //     "rock",
    //     user2,
    //     new ArrayList<>()
    //   );

    //   // mock playlist songs
    //   PlaylistSong song1 = new PlaylistSong("track1", playlist1);
    //   PlaylistSong song2 = new PlaylistSong("track2", playlist1);
    //   PlaylistSong song3 = new PlaylistSong("track3", playlist2);

    //   playlist1.getPlaylistSongs().add(song1);
    //   playlist1.getPlaylistSongs().add(song2);
    //   playlist2.getPlaylistSongs().add(song3);

    //   playlistRepository.save(playlist1);
    //   playlistRepository.save(playlist2);

    //   playlistSongRepository.save(song1);
    //   playlistSongRepository.save(song2);
    //   playlistSongRepository.save(song3);
    // };
  }
}
