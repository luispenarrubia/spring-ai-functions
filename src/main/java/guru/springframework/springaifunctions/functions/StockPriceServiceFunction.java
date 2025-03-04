package guru.springframework.springaifunctions.functions;

import guru.springframework.springaifunctions.model.StockPriceRequest;
import guru.springframework.springaifunctions.model.StockPriceResponse;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.function.Function;

/**
 * Created by jt, Spring Framework Guru.
 */
public class StockPriceServiceFunction implements Function<StockPriceRequest, StockPriceResponse> {

    public static final String STOCK_PRICE_URL = "https://api.api-ninjas.com/v1/stockprice";

    private final String apiNinjasKey;

    public StockPriceServiceFunction(String apiNinjasKey) {
        this.apiNinjasKey = apiNinjasKey;
    }

    @Override
    public StockPriceResponse apply(StockPriceRequest request) {
        RestClient restClient = RestClient.builder()
                .baseUrl(STOCK_PRICE_URL)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set("X-Api-Key", apiNinjasKey);
                    httpHeaders.set("Accept", "application/json");
                    httpHeaders.set("Content-Type", "application/json");
                }).build();        

        JsonNode jsonResponse = restClient.get().uri(uriBuilder -> {
            System.out.println("Building URI for weather request: " + request);

            uriBuilder.queryParam("ticker", request.ticker());

            return uriBuilder.build();
        }).retrieve().body(JsonNode.class);

        System.out.println("jsonResponse: " + jsonResponse);

        if (jsonResponse.isEmpty()) {
            return new StockPriceResponse(null, null, null, null, null, null);
        }
        return new ObjectMapper().convertValue(jsonResponse, StockPriceResponse.class);
 

    }
}