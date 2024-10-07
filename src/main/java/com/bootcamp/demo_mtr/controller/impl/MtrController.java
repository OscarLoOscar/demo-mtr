package com.bootcamp.demo_mtr.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
// Component
// -> @Configuration
import com.bootcamp.demo_mtr.controller.MTROperation;
import com.bootcamp.demo_mtr.model.MtrDTO;
import com.bootcamp.demo_mtr.service.MTRService;

// -> @Controller
// -> @Service
// -> @Repository
@RestController
public class MtrController implements MTROperation {

  @Autowired
  private MTRService mtrService;

  @Override
  public MtrDTO getTime(String line, String station) {
    return mtrService.getTime(line, station);
  }

}
