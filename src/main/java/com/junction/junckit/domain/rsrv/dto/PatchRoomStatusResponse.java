package com.junction.junckit.domain.rsrv.dto;

import com.junction.junckit.domain.rsrv.entity.RsrvRoomStatus;
import lombok.Builder;
import lombok.Data;

@Data
public class PatchRoomStatusResponse {
  private RsrvRoomStatus status;

  @Builder
  public PatchRoomStatusResponse(RsrvRoomStatus status){
    this.status = status;
  }
}
