package com.junction.junckit.domain.user.sevice;

import com.junction.junckit.domain.rsrv.dto.PatchRoomStatusRequest;
import com.junction.junckit.domain.rsrv.dto.PatchRoomStatusResponse;
import com.junction.junckit.domain.rsrv.entity.RsrvRoom;
import com.junction.junckit.domain.rsrv.entity.RsrvRoomStatus;
import com.junction.junckit.domain.user.entity.User;
import com.junction.junckit.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public User getUserInfo(Long id) {
    User user = userRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException());

    return user;
  }
}
