
package com.fabrick.task1.asteroids.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * DTO parziale per mappare la risposta del lookup Neo della NASA.
 * Contiene solo i campi utilizzati dall'esercizio.
 */
public class NasaNeoLookupResponse {

    @JsonProperty("close_approach_data")
    private List<CloseApproach> closeApproachData;

    public List<CloseApproach> getCloseApproachData() {
        return closeApproachData;
    }

    public void setCloseApproachData(List<CloseApproach> closeApproachData) {
        this.closeApproachData = closeApproachData;
    }

    public static class CloseApproach {
        @JsonProperty("close_approach_date")
        private String closeApproachDate;
        @JsonProperty("orbiting_body")
        private String orbitingBody;

        public String getCloseApproachDate() { return closeApproachDate; }
        public void setCloseApproachDate(String closeApproachDate) { this.closeApproachDate = closeApproachDate; }

        public String getOrbitingBody() { return orbitingBody; }
        public void setOrbitingBody(String orbitingBody) { this.orbitingBody = orbitingBody; }
    }
}
