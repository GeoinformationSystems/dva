package org.tud.oas.routing.gorouting;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Matrix {
    @JsonProperty("durations")
    public double[][] durations;
}