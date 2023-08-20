package com.junction.junckit.domain.user.entity;

import com.junction.junckit.common.model.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "user")
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "password")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "type")
  private UserType type;

  @Column(name = "address_x")
  private Double addressX;

  @Column(name = "address_y")
  private Double addressY;

  @Builder
  public User(Long id, String nickname, String password, UserType type, Double addressX, Double addressY){
    this.id = id;
    this.nickname = nickname;
    this.password = password;
    this.type = type;
    this.addressX = addressX;
    this.addressY = addressY;
  }

}
