package com.challenger.users.service.impl;

import com.challenger.users.mapper.UserMapper;
import com.challenger.users.model.User;
import com.challenger.users.repository.UserRepository;
import com.challenger.users.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public List<User> getAllUsers() {
    return userMapper.toResponseList(userRepository.findAll());
  }
}
