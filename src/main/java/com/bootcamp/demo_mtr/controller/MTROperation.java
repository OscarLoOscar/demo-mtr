package com.bootcamp.demo_mtr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo_mtr.model.MtrDTO;

public interface MTROperation {


  @GetMapping("/getTime")
  MtrDTO getTime(@RequestParam String station);
}
