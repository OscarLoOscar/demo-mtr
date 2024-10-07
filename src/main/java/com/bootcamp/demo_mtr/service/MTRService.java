package com.bootcamp.demo_mtr.service;

import com.bootcamp.demo_mtr.model.MtrDTO;

public interface MTRService {

  MtrDTO getTime(String line, String station);

} 