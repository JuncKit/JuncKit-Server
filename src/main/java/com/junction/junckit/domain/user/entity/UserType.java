package com.junction.junckit.domain.user.entity;

import java.util.Locale;

public enum UserType {
  PASSENGER,
  DRIVER;

  public static UserType of(String problemType) {
    return UserType.valueOf(problemType.toUpperCase(Locale.ROOT));
  }
}
