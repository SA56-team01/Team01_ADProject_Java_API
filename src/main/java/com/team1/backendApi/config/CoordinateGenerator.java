package com.team1.backendApi.config;

import java.util.Random;

public class CoordinateGenerator {

  private static final double CENTER_LATITUDE = 1.3521; // Center latitude of Singapore
  private static final double CENTER_LONGITUDE = 103.8198; // Center longitude of Singapore

  private Random random;

  public CoordinateGenerator() {
    random = new Random();
  }

  public double generateRandomLongitude() {
    double radius = getRandomRadius(); // Generate random radius within 5km

    double rd = radius / 111300; // Convert radius from meters to degrees

    // Random angle
    double u = random.nextDouble();
    double v = random.nextDouble();
    double w = rd * Math.sqrt(u);
    double t = 2 * Math.PI * v;
    double x = w * Math.cos(t);
    double y = w * Math.sin(t);

    // Adjust the x-coordinate for the shrinking of the east-west distances
    double xp = x / Math.cos(Math.toRadians(CENTER_LATITUDE));

    // Calculate longitude
    double longitude = xp + CENTER_LONGITUDE;

    return longitude;
  }

  public double generateRandomLatitude() {
    double radius = getRandomRadius(); // Generate random radius within 5km

    double rd = radius / 111300; // Convert radius from meters to degrees

    // Random angle
    double u = random.nextDouble();
    double v = random.nextDouble();
    double w = rd * Math.sqrt(u);
    double t = 2 * Math.PI * v;
    double x = w * Math.cos(t);
    double y = w * Math.sin(t);

    // Calculate latitude
    double latitude = y + CENTER_LATITUDE;

    return latitude;
  }

  private double getRandomRadius() {
    // Generate random radius within 12km (12000 meters)
    double radius = random.nextDouble() * 12000;

    return radius;
  }
}
