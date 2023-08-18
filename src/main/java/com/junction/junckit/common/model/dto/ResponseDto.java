package com.junction.junckit.common.model.dto;

import java.io.Serializable;
import javax.swing.text.html.HTML;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDto<T> implements Serializable {

  private HttpStatus code;
  private String msg;
  private T data;

  public static <T> ResponseEntity<ResponseDto<T>> ok(HttpStatus code, String msg, T data) {
    return ResponseEntity.ok(new ResponseDto<T>(HttpStatus.OK, "OK", data));
  }

  public static <T> ResponseEntity<ResponseDto<T>> created(HttpStatus code, String msg, T data) {
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(new ResponseDto<T>(HttpStatus.CREATED, "CREATED", data));
  }

  public static ResponseEntity<Void> noContent() {
    return ResponseEntity
      .status(HttpStatus.NO_CONTENT)
      .build();
  }
}