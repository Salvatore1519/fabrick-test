
package com.fabrick.task1.asteroids.dto;

/**
 * DTO di output per il path: fromPlanet, toPlanet, fromDate, toDate
 */
public class PathDto {
    private String fromPlanet;
    private String toPlanet;
    private String fromDate;
    private String toDate;

    public PathDto() {}

    public PathDto(String fromPlanet, String toPlanet, String fromDate, String toDate) {
        this.fromPlanet = fromPlanet;
        this.toPlanet = toPlanet;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getFromPlanet() { return fromPlanet; }
    public void setFromPlanet(String fromPlanet) { this.fromPlanet = fromPlanet; }

    public String getToPlanet() { return toPlanet; }
    public void setToPlanet(String toPlanet) { this.toPlanet = toPlanet; }

    public String getFromDate() { return fromDate; }
    public void setFromDate(String fromDate) { this.fromDate = fromDate; }

    public String getToDate() { return toDate; }
    public void setToDate(String toDate) { this.toDate = toDate; }
}
