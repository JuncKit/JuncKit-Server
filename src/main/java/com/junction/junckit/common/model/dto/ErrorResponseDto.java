package com.junction.junckit.common.model.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto implements Serializable {
  private final String error;
  private final String error_description;
}
