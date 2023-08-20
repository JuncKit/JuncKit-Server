package com.junction.junckit.domain.rsrv.dto;

import com.junction.junckit.domain.rsrv.entity.RsrvRoom;
import com.junction.junckit.domain.rsrv.entity.RsrvRoomStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RsrvRoomDto {
  private Long id;
  private String creater_name;
  private String creater_type;
  private RsrvRoomStatus status;

  @Builder
  public RsrvRoomDto(
    RsrvRoom entity
  ) {
    this.id = entity.getId();
    this.creater_name = entity.getUser().getNickname();
    this.creater_type = String.valueOf(entity.getUser().getType());
    this.status = entity.getStatus();
  }
}
