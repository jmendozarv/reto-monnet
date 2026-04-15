package com.challenger.users.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
  @Id
  private Long id;

  private String name;
  private String username;
  private String email;

  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private String lat;
  private String lng;

  private String phone;
  private String website;

  private String companyName;
  private String companyCatchPhrase;
  private String companyBs;
}
