package guru.springframework.springaifunctions.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;

public record StockPriceResponse(@JsonPropertyDescription("The ticker symbol of the stock (e.g., AAPL)") String ticker,
                                @JsonPropertyDescription("The name of the company (e.g., Apple Inc.)") String name,
                                @JsonPropertyDescription("The price of the Stock in 0.00 decimal format (e.g., 238.03)") BigDecimal price,
                                @JsonPropertyDescription("The exchange the stock is traded on (e.g., NASDAQ)") String exchange,
                                @JsonPropertyDescription("The latest update of the Stock in EPOCH (e.g., 1741035602)") Long updated,
                                @JsonPropertyDescription("The currency of the Stock price (e.g., USD)") String currency) {
}