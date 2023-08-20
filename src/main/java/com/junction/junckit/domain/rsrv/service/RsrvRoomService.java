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

}