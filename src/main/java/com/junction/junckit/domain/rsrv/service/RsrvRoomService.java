package com.junction.junckit.domain.rsrv.service;

import com.junction.junckit.domain.rsrv.dto.PatchRoomStatusRequest;
import com.junction.junckit.domain.rsrv.dto.PatchRoomStatusResponse;
import com.junction.junckit.domain.rsrv.dto.PostRoomRequest;
import com.junction.junckit.domain.rsrv.dto.RsrvRoomDto;
import com.junction.junckit.domain.rsrv.entity.RsrvRoom;
import com.junction.junckit.domain.rsrv.entity.RsrvRoomStatus;
import com.junction.junckit.domain.rsrv.repository.RsrvRoomRepository;
import com.junction.junckit.domain.user.entity.User;
import com.junction.junckit.domain.user.entity.UserType;
import com.junction.junckit.domain.user.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RsrvRoomService {

  private final UserRepository userRepository;
  private final RsrvRoomRepository rsrvRoomRepository;

  public List<RsrvRoomDto> getActiveRoomsByType(String type) {
    List<RsrvRoomDto> result = rsrvRoomRepository.findAllByTypeAndStatus(
        UserType.valueOf(type), RsrvRoomStatus.WAIT
    ).stream()
      .map(RsrvRoomDto::new)
      .collect(Collectors.toList());

    return result;
  }

  public RsrvRoom createRoom(PostRoomRequest requestDto) {
    User user = userRepository.findById(requestDto.getUserId()).orElseThrow();
    RsrvRoom result = rsrvRoomRepository.save(
      RsrvRoom
        .builder()
        .user(user)
        .type(user.getType())
        .status(RsrvRoomStatus.WAIT)
        .build()
    );

    return result;
  }

  @Transactional
  public PatchRoomStatusResponse patchRoomStatus(Long id, PatchRoomStatusRequest requestDto) {
    RsrvRoom room = rsrvRoomRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException());
    room.updateStatus(RsrvRoomStatus.valueOf(requestDto.getStatus()));

    return PatchRoomStatusResponse
      .builder()
      .status(RsrvRoomStatus.valueOf(requestDto.getStatus()))
      .build();
  }

  @Transactional
  public String deleteRoom(Long id) {
    RsrvRoom room = rsrvRoomRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException());

    rsrvRoomRepository.delete(room);

    return "Rsrv Deleted";
  }

}
