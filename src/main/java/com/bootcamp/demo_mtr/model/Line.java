package com.bootcamp.demo_mtr.model;

import lombok.Getter;

@Getter
public enum Line {
  AEL("Airport Express"), //
  TCL("Tung Chung Line"), //
  TML("Tuen Ma Line"), //
  TKL("Tseung Kwan O Line"), //
  EAL("East Rail Line"), //
  SIL("South Island Line"), //
  TWL("Tsuen Wan Line"), //
  ISL("Island Line"), //
  KTL("Kwun Tong Line");

  private String line;
  
  Line(String line) {
    this.line = line;
  }
}
