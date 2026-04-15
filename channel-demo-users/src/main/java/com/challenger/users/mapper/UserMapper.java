package com.challenger.users.mapper;

import com.challenger.users.dto.JsonPlaceholderUserDto;
import com.challenger.users.dto.UserResponse;
import com.challenger.users.entity.UserEntity;
import com.challenger.users.model.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "street", source = "address.street")
  @Mapping(target = "suite", source = "address.suite")
  @Mapping(target = "city", source = "address.city")
  @Mapping(target = "zipcode", source = "address.zipcode")
  @Mapping(target = "lat", source = "address.geo.lat")
  @Mapping(target = "lng", source = "address.geo.lng")
  @Mapping(target = "companyName", source = "company.name")
  @Mapping(target = "companyCatchPhrase", source = "company.catchPhrase")
  @Mapping(target = "companyBs", source = "company.bs")
  UserEntity toEntity(JsonPlaceholderUserDto dto);

  @Mapping(target = "address.street", source = "street")
  @Mapping(target = "address.suite", source = "suite")
  @Mapping(target = "address.city", source = "city")
  @Mapping(target = "address.zipcode", source = "zipcode")
  @Mapping(target = "address.geo.lat", source = "lat")
  @Mapping(target = "address.geo.lng", source = "lng")
  @Mapping(target = "company.name", source = "companyName")
  @Mapping(target = "company.catchPhrase", source = "companyCatchPhrase")
  @Mapping(target = "company.bs", source = "companyBs")
  User toModel(UserEntity entity);

  UserResponse toResponse(UserEntity entity);

  List<User> toResponseList(List<UserEntity> entities);
}