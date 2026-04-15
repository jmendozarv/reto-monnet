package com.challenger.users.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.challenger.users.entity.UserEntity;
import com.challenger.users.mapper.UserMapper;
import com.challenger.users.model.User;
import com.challenger.users.repository.UserRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias de UserServiceImpl")
class UserServiceImplTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private UserMapper userMapper;

  @InjectMocks
  private UserServiceImpl userService;

  @Test
  @DisplayName("Debe devolver usuarios mapeados desde el repositorio")
  void getAllUsers_returnsMappedUsers() {
    UserEntity entity = UserEntity.builder().id(1L).name("Leanne Graham").build();

    User user = new User();
    user.setId(1);
    user.setName("Leanne Graham");

    when(userRepository.findAll()).thenReturn(List.of(entity));
    when(userMapper.toResponseList(List.of(entity))).thenReturn(List.of(user));

    List<User> result = userService.getAllUsers();

    assertEquals(1, result.size());
    assertEquals("Leanne Graham", result.get(0).getName());
    verify(userRepository).findAll();
    verify(userMapper).toResponseList(List.of(entity));
  }
}

