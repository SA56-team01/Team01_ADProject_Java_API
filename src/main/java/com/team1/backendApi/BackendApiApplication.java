package com.team1.backendApi;

import com.team1.backendApi.config.CorsConfig;
import com.team1.backendApi.model.Admin;
import com.team1.backendApi.model.Feedback;
import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.PlaylistSong;
import com.team1.backendApi.model.User;
import com.team1.backendApi.repository.AdminRepository;
import com.team1.backendApi.repository.FeedbackRepository;
import com.team1.backendApi.repository.PlaylistRepository;
import com.team1.backendApi.repository.PlaylistSongRepository;
import com.team1.backendApi.repository.UserRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
  FeedbackRepository feedbackRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public static void main(String[] args) {
    SpringApplication.run(BackendApiApplication.class, args);
  }

  private String[] feedbackTexts = {
    "The playlist suggestions are amazing!",
    "This app has made discovering music so much fun.",
    "I love the variety of songs in the playlists.",
    "The generated playlists match my taste perfectly.",
    "Great job on creating unique playlists.",
    "I can't stop listening to the playlists from this app.",
    "The app's recommendations are on point.",
    "My friends are jealous of my awesome playlists.",
    "This is the best music app I've ever used.",
    "The playlist for my workout session was fire!",
  };

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
        "user1@example.com"
      );

      userRepository.saveAndFlush(user1);

      for (int i = 2; i <= 10; i++) {
        String username = "user" + i;
        String email = "user" + i + "@example.com";
        User user = new User(username, "SG", email);
        userRepository.saveAndFlush(user);
      }

      Random random = new Random();

      List<User> users = userRepository.findAll().subList(0, 10);

      for (int i = 1; i <= 100; i++) {
        String playlistName = "Playlist " + i;
        String spotifyPlaylistId = "spotifyPlaylistId" + i;
        //String timestamp = "2023-08-" + (14 + i % 7); // Generating a random date between 2022-08-14 and 2023-08-20

        // Generating a random date between 2022-08-14 and 2023-08-20
        LocalDate startDate = LocalDate.of(2022, 8, 14);
        LocalDate endDate = LocalDate.of(2023, 8, 20);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        LocalDate randomDate = startDate.plusDays(
          random.nextInt((int) daysBetween + 1)
        );

        // Generating a random time (hh:mm:ss)
        LocalTime randomTime = LocalTime.of(
          random.nextInt(24),
          random.nextInt(60),
          random.nextInt(60)
        );

        String timestamp = randomDate.toString() + " " + randomTime.toString();

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

      for (int i = 1; i <= 30; i++) {
        Feedback feedback = new Feedback();
        feedback.setFeedbackText(
          feedbackTexts[random.nextInt(feedbackTexts.length)]
        );

        // Generating a random date between 2022-08-14 and 2023-08-20
        LocalDate startDate = LocalDate.of(2022, 8, 14);
        LocalDate endDate = LocalDate.of(2023, 8, 20);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        LocalDate randomDate = startDate.plusDays(
          random.nextInt((int) daysBetween + 1)
        );

        // Generating a random time (hh:mm:ss)
        LocalTime randomTime = LocalTime.of(
          random.nextInt(24),
          random.nextInt(60),
          random.nextInt(60)
        );

        String fbTimestamp =
          randomDate.toString() + " " + randomTime.toString();
        feedback.setFbTimestamp(fbTimestamp);

        // Associate the feedback with a random user
        User randomUser = users.get(random.nextInt(users.size()));
        feedback.setUser(randomUser);

        feedbackRepository.save(feedback);
      }
    };
  }
}
