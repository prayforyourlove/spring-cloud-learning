package com.itmuch.cloud.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class MyFallbackProvider implements ZuulFallbackProvider {
  @Override
  public String getRoute() {
    //api服务id，如果需要所有调用都支持回退，则return "*"或return nul
    return "service-provider-user";
  }

  @Override
  public ClientHttpResponse fallbackResponse() {
    return new ClientHttpResponse() {
      /**
       * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的，
       * 不应该把api的404,500等问题抛给客户端
       * 网关和api服务集群对于客户端来说是黑盒子
       */
      @Override
      public HttpStatus getStatusCode() throws IOException {
        return HttpStatus.BAD_REQUEST;
      }

      @Override
      public int getRawStatusCode() throws IOException {
        return HttpStatus.BAD_REQUEST.value();
      }

      @Override
      public String getStatusText() throws IOException {
        return HttpStatus.BAD_REQUEST.getReasonPhrase();
      }

      @Override
      public void close() {
      }

      @Override
      public InputStream getBody() throws IOException {
        return new ByteArrayInputStream(("fallback" + MyFallbackProvider.this.getRoute()).getBytes());
      }

      @Override
      public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
      }
    };
  }
}