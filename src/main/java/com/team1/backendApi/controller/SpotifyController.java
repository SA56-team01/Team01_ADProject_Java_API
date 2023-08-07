package com.team1.backendApi.controller;

import com.team1.backendApi.config.SpotifyConfig;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class SpotifyController {

    private final SpotifyConfig spotifyConfig;
    private final RestTemplate restTemplate;

    public SpotifyController(SpotifyConfig spotifyConfig, RestTemplateBuilder restTemplateBuilder) {
        this.spotifyConfig = spotifyConfig;
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/artist/detail")
    public ResponseEntity<String> getArtistDetail() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + spotifyConfig.getAccessToken());

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = spotifyConfig.getSpotifyApiBaseUrl() + "/v1/artists/" + spotifyConfig.getArtistId();

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }


    @GetMapping("/user/detail")
    public ResponseEntity<String> getUserDetail() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + spotifyConfig.getAccessToken());

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = spotifyConfig.getSpotifyApiBaseUrl() + "/v1/users/" + spotifyConfig.getUserId();

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}

