package com.junction.junckit.domain.message;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

  private final SimpMessageSendingOperations sendingOperations;
                                        
  @MessageMapping("/chat/message")
  public void enter(RsrvMessage message) {
    if (RsrvMessage.MessageType.ENTER.equals(message.getType())) {
      message.setMessage(message.getSender()+"님이 입장하였습니다.");
    }
    sendingOperations.convertAndSend("/topic/chat/room/"+message.getId(),message);
  }
}
