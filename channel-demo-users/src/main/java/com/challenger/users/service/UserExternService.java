package com.challenger.users.service;

import com.challenger.users.dto.JsonPlaceholderUserDto;
import com.challenger.users.entity.UserEntity;
import com.challenger.users.mapper.UserMapper;
import com.challenger.users.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserExternService {
  private final RestTemplate restTemplate = new RestTemplate();
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";

  public void fetchAndStoreUsers() {
    JsonPlaceholderUserDto[] users =
        restTemplate.getForObject(USERS_URL, JsonPlaceholderUserDto[].class);

    if (users == null || users.length == 0) {
      return;
    }

    List<UserEntity> entities = Arrays.stream(users)
        .map(userMapper::toEntity)
        .toList();

    userRepository.saveAll(entities);
  }
}
