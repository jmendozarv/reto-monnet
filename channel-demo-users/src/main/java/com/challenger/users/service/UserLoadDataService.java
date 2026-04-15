package com.challenger.users.service;

import com.challenger.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoadDataService implements CommandLineRunner {

  private final UserExternService externService;
  private final UserRepository userRepository;

  @Override
  public void run(String... args) {
    if (userRepository.count() == 0) {
      externService.fetchAndStoreUsers();
    }
  }
}
