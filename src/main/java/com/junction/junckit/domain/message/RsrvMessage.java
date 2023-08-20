package com.junction.junckit.domain.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RsrvMessage {
  public enum MessageType {
    ENTER, TALK
  }

  private MessageType type;
  //채팅방 ID
  private String id;
  //보내는 사람
  private String sender;
  //내용
  private String message;
}
