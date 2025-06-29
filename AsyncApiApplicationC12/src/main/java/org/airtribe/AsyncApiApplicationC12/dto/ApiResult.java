package org.airtribe.AsyncApiApplicationC12.dto;

import java.util.List;


public class ApiResult {

  public List<ApiMeasurement> products;

  public ApiResult(List<ApiMeasurement> products) {
    this.products = products;
  }

  public List<ApiMeasurement> getProducts() {
    return products;
  }

  public void setProducts(List<ApiMeasurement> products) {
    this.products = products;
  }
}
