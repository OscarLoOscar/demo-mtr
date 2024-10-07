package com.bootcamp.demo_mtr.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class ApiUtil {
  
  @Value("${api.domain}")
  String domain;

  @Value("${api.version}")
  String version;

  @Value("${api.pathA}")
  String pathA;

  @Value("${api.pathB}")
  String pathB;

  @Value("${api.pathC}")
  String pathC;

  
  public String getUrl(String line , String station ){
    return UriComponentsBuilder.newInstance()//
    .scheme(Scheme.HTTPS.toString())//
    .host(domain)//
    .path(version)//
    .path(pathA)//
    .path(pathB)//
    .path(pathC)//
    // .pathSegment(path)// 
    .queryParam("line", line)//
    .queryParam("sta", station)//
    .build(false)//
    .toUriString();
  }
}
