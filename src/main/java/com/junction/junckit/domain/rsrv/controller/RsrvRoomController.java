package com.junction.junckit.domain.rsrv.controller;

import com.junction.junckit.domain.rsrv.dto.PatchRoomStatusRequest;
import com.junction.junckit.domain.rsrv.dto.PatchRoomStatusResponse;
import com.junction.junckit.domain.rsrv.dto.PostRoomRequest;
import com.junction.junckit.domain.rsrv.dto.RsrvRoomDto;
import com.junction.junckit.domain.rsrv.entity.RsrvRoom;
import com.junction.junckit.domain.rsrv.service.RsrvRoomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rsrv")
public class RsrvRoomController {
  private final RsrvRoomService rsrvService;

  @GetMapping("/rooms")
  @ResponseBody
  public List<RsrvRoomDto> getActiveRoomList(@RequestParam String type) {
    return rsrvService.getActiveRoomsByType(type);
  }

  @PostMapping("/rooms")
  @ResponseBody
  public RsrvRoom createRoom(
    @RequestBody PostRoomRequest requestDto
    ) {
    return rsrvService.createRoom(requestDto);
  }

  @PatchMapping("/rooms/{room_id}")
  public PatchRoomStatusResponse patchRoomStatus(
    @PathVariable Long room_id,
    @RequestBody PatchRoomStatusRequest requestDto
  ){
    return rsrvService.patchRoomStatus(room_id, requestDto);
  }

  @DeleteMapping("/rooms/{room_id}")
  public String deleteRoom(
    @PathVariable Long room_id
  ){
    return rsrvService.deleteRoom(room_id);
  }
}