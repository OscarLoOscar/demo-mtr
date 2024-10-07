package com.bootcamp.demo_mtr.model.mapper;

import com.bootcamp.demo_mtr.model.Line;
import com.bootcamp.demo_mtr.model.Station;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class StationLineMapper {

  private static final Map<Station, List<Line>> stationLinesMap =
      new EnumMap<>(Station.class);

  static {
    for (Station station : Station.values()) {
      switch (station) {
        case ADM:
          stationLinesMap.put(station,
              List.of(Line.EAL, Line.SIL, Line.TWL, Line.ISL));
          break;
        case TSY:
        case KOW:
        case HOK:
          stationLinesMap.put(station, List.of(Line.AEL, Line.TCL));
          break;
        case LAK:
          stationLinesMap.put(station, List.of(Line.TWL, Line.TCL));
          break;
        case MOK:
        case YMT:
        case PRE:
          stationLinesMap.put(station, List.of(Line.TWL, Line.KTL));
          break;
        case NAC:
          stationLinesMap.put(station, List.of(Line.TCL, Line.TML));
          break;
        case YAT:
        case TIK:
          stationLinesMap.put(station, List.of(Line.KTL, Line.TKL));
          break;
        case NOP:
        case QUB:
          stationLinesMap.put(station, List.of(Line.TKL, Line.ISL));
          break;
        case HOM:
        case DIH:
          stationLinesMap.put(station, List.of(Line.KTL, Line.TML));
          break;
        case TAW:
        case HUH:
          stationLinesMap.put(station, List.of(Line.EAL, Line.TML));
          break;
        case KOT:
          stationLinesMap.put(station, List.of(Line.EAL, Line.KTL));
          break;
        case CEN:
          stationLinesMap.put(station, List.of(Line.TWL, Line.ISL));
          break;
        case AIR:
        case AWE:
          stationLinesMap.put(station, List.of(Line.AEL));
          break;
        case TUC:
        case SUN:
        case OLY:
          stationLinesMap.put(station, List.of(Line.TCL));
          break;
        case MEF:
          stationLinesMap.put(station, List.of(Line.TML, Line.TWL));
          break;
        case WKS:
        case MOS:
        case HEO:
        case TSH:
        case SHM:
        case CIO:
        case STW:
        case CKT:
        case HIK:
        case KAT:
        case SUW:
        case TKW:
        case ETS:
        case AUS:
        case TWW:
        case KSR:
        case YUL:
        case LOP:
        case TIS:
        case SIH:
        case TUM:
          stationLinesMap.put(station, List.of(Line.TML));
          break;
        case TKO:
        case LHP:
        case HAH:
        case POA:
          stationLinesMap.put(station, List.of(Line.TKL));
          break;
        case EXC:
        case MKK:
        case SHT:
        case FOT:
        case RAC:
        case UNI:
        case TAP:
        case TWO:
        case FAN:
        case SHS:
        case LOW:
        case LMC:
          stationLinesMap.put(station, List.of(Line.EAL));
          break;
        case OCP:
        case WCH:
        case LET:
        case SOH:
          stationLinesMap.put(station, List.of(Line.SIL));
          break;
        case TST:
        case JOR:
        case SSP:
        case CSW:
        case LCK:
        case KWF:
          stationLinesMap.put(station, List.of(Line.TWL));
          break;
        case WHA:
        case SKM:
        case LOF:
        case WTS:
        case CHH:
        case KOB:
        case NTK:
        case KWT:
        case LAT:
          stationLinesMap.put(station, List.of(Line.KTL));
          break;
        case KET:
        case HKU:
        case SYP:
        case SHW:
        case WAC:
        case CAB:
        case TIH:
        case FOH:
        case TAK:
        case SWH:
        case SKW:
        case HFC:
        case CHW:
          stationLinesMap.put(station, List.of(Line.ISL));
          break;
      }
    }
  }

    public List<Line> getLinesForStation(Station station) {
      return stationLinesMap.getOrDefault(station, List.of());
  }
  }
