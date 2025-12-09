
package com.fabrick.task2.airports.dto;

/**
 * DTO per rappresentare un aeroporto.
 */
public class AirportDto {
    private String id;
    private String name;
    private String state;
    private String country;
    private double latitude;
    private double longitude;
    private double elevation;

    public AirportDto() {}

    public AirportDto(String id, String name, String state, String country, double latitude, double longitude, double elevation) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getElevation() { return elevation; }
    public void setElevation(double elevation) { this.elevation = elevation; }
}
