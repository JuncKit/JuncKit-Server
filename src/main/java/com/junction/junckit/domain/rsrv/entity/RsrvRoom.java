package com.junction.junckit.domain.rsrv.entity;

import com.junction.junckit.common.model.entity.BaseEntity;
import com.junction.junckit.domain.user.entity.User;
import com.junction.junckit.domain.user.entity.UserType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@DynamicInsert
@NoArgsConstructor
@Table(name = "rsrvroom")
public class RsrvRoom extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @Enumerated(EnumType.STRING)
  @Column(name = "type")
  private UserType type;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private RsrvRoomStatus status;

  @Builder
  public RsrvRoom(Long id, User user, UserType type, RsrvRoomStatus status){
    this.id = id;
    this.user = user;
    this.type = type;
    this.status = status;
  }

  public void updateStatus(RsrvRoomStatus status) {
    this.status = status;
  }
}
