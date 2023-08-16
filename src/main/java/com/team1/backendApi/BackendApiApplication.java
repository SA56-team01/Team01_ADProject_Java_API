package com.team1.backendApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.team1.backendApi.config.CorsConfig;
import com.team1.backendApi.model.Admin;
import com.team1.backendApi.model.Role;

import com.team1.backendApi.repository.AdminRepository;

import org.springframework.context.annotation.Import;

@Import(CorsConfig.class)
@SpringBootApplication
public class BackendApiApplication {
    
    @Autowired
    AdminRepository adminRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

  @Bean
  CommandLineRunner runner() {
    return args -> {

    // userRepository.saveAll(Arrays.asList(user1, user2));
    // playlistRepository.saveAll(Arrays.asList(playlist1, playlist2));
    // playlistSongRepository.saveAll(Arrays.asList(song1, song2, song3, song4));
     // Create a new admin
        Role adminRole = new Role("ROLE_ADMIN");
        Admin admin = new Admin();
        admin.setUsername("admin2");
        admin.setPassword(passwordEncoder.encode("secretpassword"));
           
        // Save the admin with hashed password
        adminRepo.save(admin);

      //   Admin admin1 = new Admin("admin1", "password1", adminRole);
      //   Admin admin2 = new Admin("admin2", "password2", adminRole);

      //   adminRepository.save(admin1);
      //   adminRepository.save(admin2);
      // User user1 = new User("_feroz_", "SG", "user1@example.com", userRole);

      //   User user2 = new User(
      //     "31yi3mwekgnigzuk5ynbzwrhwm34",
      //     "SG",
      //     "user2@example.com",
      //     userRole
      //   );
      //   // Now you can save the admins and users
      //   adminRepository.saveAll(Arrays.asList(admin1, admin2));
      //   userRepository.saveAll(Arrays.asList(user1, user2));
      //   Playlist playlist1 = new Playlist(
      //     1L,
      //     "My Playlist 1",
      //     "2023-08-13",
      //     null,
      //     null,
      //     null,
      //     0,
      //     0,
      //     0,
      //     0,
      //     0,
      //     0,
      //     0,
      //     0,
      //     0,
      //     0,
      //     0,
      //     0,
      //     null,
      //     user1,
      //     new ArrayList<>()
      //   );
      // Playlist playlist2 = new Playlist(2L, "My Playlist 2", null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, user2, new ArrayList<>());

      //   Playlist playlist = new Pla

      //PlaylistSong song1 = new PlaylistSong("track1", playlist1);
      // PlaylistSong song2 = new PlaylistSong("track2", playlist1);
      // playlist1.getPlaylistSongs().addAll(Arrays.asList(song1, song2));

      // PlaylistSong song3 = new PlaylistSong("track3", playlist2);
      // PlaylistSong song4 = new PlaylistSong("track4", playlist2);
      // playlist2.getPlaylistSongs().addAll(Arrays.asList(song3, song4));

      // playlistRepository.saveAll(Arrays.asList(playlist1, playlist2));
      // playlistSongRepository.saveAll(Arrays.asList(song1, song2, song3, song4));

    };
  }
}
