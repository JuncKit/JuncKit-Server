package com.junction.junckit.domain.rsrv.repository;

import com.junction.junckit.domain.rsrv.entity.RsrvRoom;
import com.junction.junckit.domain.rsrv.entity.RsrvRoomStatus;
import com.junction.junckit.domain.user.entity.UserType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RsrvRoomRepository extends JpaRepository<RsrvRoom, Long> {
}
