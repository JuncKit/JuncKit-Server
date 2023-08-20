package com.junction.junckit.domain.rsrv.entity;

import java.util.Locale;

public enum RsrvRoomStatus {
  WAIT,
  SUCCESS,
  FAIL;

  public static RsrvRoomStatus of(String problemType) {
    return RsrvRoomStatus.valueOf(problemType.toUpperCase(Locale.ROOT));
  }
}
