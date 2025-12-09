
package com.fabrick.task2.airports.dto;

/**
 * DTO per rappresentare una observation station.

 */
public class StationDto {
    private String id;
    private String site;
    private String state;
    private String country;
    private double latitude;
    private double longitude;
    private double elevation;

    public StationDto() {}

    public StationDto(String id, String site, String state, String country, double latitude, double longitude, double elevation) {
        this.id = id;
        this.site = site;
        this.state = state;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSite() { return site; }
    public void setSite(String site) { this.site = site; }

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
