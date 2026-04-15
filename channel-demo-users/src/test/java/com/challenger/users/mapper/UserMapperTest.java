package com.challenger.users.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.challenger.users.entity.UserEntity;
import com.challenger.users.model.User;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

@DisplayName("Pruebas unitarias de UserMapper")
class UserMapperTest {

  private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @Test
  @DisplayName("Debe mapear address y company anidados desde UserEntity")
  void toModel_mapsNestedAddressAndCompany() {
    UserEntity entity = UserEntity.builder()
        .id(1L)
        .name("Leanne Graham")
        .username("Bret")
        .email("Sincere@april.biz")
        .street("Kulas Light")
        .suite("Apt. 556")
        .city("Gwenborough")
        .zipcode("92998-3874")
        .lat("-37.3159")
        .lng("81.1496")
        .phone("1-770-736-8031 x56442")
        .website("hildegard.org")
        .companyName("Romaguera-Crona")
        .companyCatchPhrase("Multi-layered client-server neural-net")
        .companyBs("harness real-time e-markets")
        .build();

    User user = userMapper.toModel(entity);

    assertNotNull(user);
    assertNotNull(user.getAddress());
    assertNotNull(user.getAddress().getGeo());
    assertNotNull(user.getCompany());

    assertEquals("Kulas Light", user.getAddress().getStreet());
    assertEquals("81.1496", user.getAddress().getGeo().getLng());
    assertEquals("Romaguera-Crona", user.getCompany().getName());
    assertEquals("Multi-layered client-server neural-net", user.getCompany().getCatchPhrase());
  }

  @Test
  @DisplayName("Debe mapear una lista de entidades a lista de usuarios con anidados")
  void toResponseList_mapsListWithNestedFields() {
    UserEntity entity = UserEntity.builder()
        .id(2L)
        .name("Ervin Howell")
        .username("Antonette")
        .email("Shanna@melissa.tv")
        .street("Victor Plains")
        .suite("Suite 879")
        .city("Wisokyburgh")
        .zipcode("90566-7771")
        .lat("-43.9509")
        .lng("-34.4618")
        .phone("010-692-6593 x09125")
        .website("anastasia.net")
        .companyName("Deckow-Crist")
        .companyCatchPhrase("Proactive didactic contingency")
        .companyBs("synergize scalable supply-chains")
        .build();

    List<User> users = userMapper.toResponseList(List.of(entity));

    assertEquals(1, users.size());
    assertNotNull(users.get(0).getAddress());
    assertNotNull(users.get(0).getCompany());
    assertEquals("Deckow-Crist", users.get(0).getCompany().getName());
  }
}

