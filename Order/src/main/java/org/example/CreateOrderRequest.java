package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class CreateOrderRequest {
    @JsonProperty("price")
    private final Integer price;
    @JsonProperty("products")
    private final String products;
}
