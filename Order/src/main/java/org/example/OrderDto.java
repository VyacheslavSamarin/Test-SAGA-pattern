package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderDto {
    @JsonProperty("id")
    private final Long id;
    @JsonProperty("price")
    private final Integer price;
    @JsonProperty("products")
    private final String products;
}
