package guru.springframework.springaifunctions.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * Created by jt, Spring Framework Guru.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonClassDescription("Stock Price API request")
public record StockPriceRequest(@JsonProperty(required = true,
        value = "ticker") @JsonPropertyDescription("The stock ticker symbol (e.g., AAPL)") String ticker){
}