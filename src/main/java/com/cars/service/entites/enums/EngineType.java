package com.cars.service.entites.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EngineType {
    @JsonProperty("electric")
    ELECTRIC,
    @JsonProperty("gas")
    GAS
}