package org.airtribe.AsyncApiApplicationC12.service;

import java.util.List;
import org.airtribe.AsyncApiApplicationC12.dto.ApiMeasurement;
import org.airtribe.AsyncApiApplicationC12.dto.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class ApiService {

  @Autowired
  private RestTemplate _restTemplate;

  @Autowired
  private WebClient _webClient;
  public String invokeHelloWorld() {
    String result = _restTemplate.getForObject("http://localhost:9300/hello", String.class);
    System.out.println(result);
    System.out.println("Request was handled by thread " + Thread.currentThread().getName());
    for(int i=0;i<10000;i++)  {
      // Simulating some work in the foreground
       //System.out.println("Doing some work in the foreground");
    }
    return result;
  }

  public ApiResult getProductsSync() {
    long startTime = System.currentTimeMillis();
    ApiResult apiResult = _restTemplate.getForObject("https://dummyjson.com/products", ApiResult.class);
    System.out.println("Request was handled by thread " + Thread.currentThread().getName());
    for (int i = 0; i < 100L; i++) {
      // Simulating some work in the foreground
       //System.out.println("Doing some work in the foreground");
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Time taken: " + (endTime - startTime));
    return apiResult;
  }

  public Mono<ApiResult> getProductsAsync() {
    long startTime = System.currentTimeMillis();
    System.out.println("Starting the async API call");

    Mono<ApiResult> apiResultMono = _webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class)
        .doOnSuccess(apiResult -> {
          long endTime = System.currentTimeMillis();
          System.out.println("Request was handled by thread " + Thread.currentThread().getName());
          for (int i = 0; i < 100L; i++) {
            // Simulating some work in the foreground
            //System.out.println("Doing some work in the foreground");
          }
          System.out.println("Time taken: " + (endTime - startTime));
        });

    System.out.println("Request was handled by thread " + Thread.currentThread().getName());
    return apiResultMono;
  }

  public ApiResult getProductsSyncWebClient() {
    long startTime = System.currentTimeMillis();
    System.out.println("Starting the sync WebClient API call");

    ApiResult apiResult = _webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class).block();

    long endTime = System.currentTimeMillis();
    System.out.println("Request was handled by thread " + Thread.currentThread().getName());
    for (int i = 0; i < 100L; i++) {
      // Simulating some work in the foreground
      //System.out.println("Doing some work in the foreground");
    }
    System.out.println("Time taken: " + (endTime - startTime));
    return apiResult;
  }

  public Mono<List<ApiResult>> getProductsInParallel() {
    long startTime = System.currentTimeMillis();
    System.out.println("Starting the async WebClient API parallel call");

    Mono<ApiResult> mono1 = _webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<ApiResult> mono2 = _webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<ApiResult> mono3 = _webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<List<ApiResult>> combinedMono = Mono.zip(mono1, mono2, mono3)
        .map(tuple -> List.of(tuple.getT1(), tuple.getT2(), tuple.getT3()))
        .doOnSuccess(apiResults -> {
          long endTime = System.currentTimeMillis();
          System.out.println("Request was handled by thread " + Thread.currentThread().getName());
          for (int i = 0; i < 100L; i++) {
            // Simulating some work in the foreground
            //System.out.println("Doing some work in the foreground");
          }
          System.out.println("Time taken: " + (endTime - startTime));
        }).doOnError(
            error -> System.err.println("Error occurred: " + error.getMessage())
        );

    System.out.println("Request was handled by thread " + Thread.currentThread().getName());
    return combinedMono;
  }

  public Mono<ApiResult> getFastestProduct() {
    long startTime = System.currentTimeMillis();
    System.out.println("Starting the async WebClient API parallel call");
    Mono<ApiResult> mono1 = _webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<ApiResult> mono2 = _webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<ApiResult> mono3 = _webClient.get().uri("https://dummyjson.com/products")
        .retrieve().bodyToMono(ApiResult.class);

    Mono<ApiResult> fastestMono = Mono.first(mono1, mono2, mono3).doOnSuccess(apiResults -> {
      long endTime = System.currentTimeMillis();
      System.out.println("Request was handled by thread " + Thread.currentThread().getName());
      for (int i = 0; i < 100L; i++) {
        // Simulating some work in the foreground
        //System.out.println("Doing some work in the foreground");
      }
      System.out.println("Time taken: " + (endTime - startTime));
    }).doOnError(
        error -> System.err.println("Error occurred: " + error.getMessage())
    );

    System.out.println("Request was handled by thread " + Thread.currentThread().getName());
    return fastestMono;
  }
}
