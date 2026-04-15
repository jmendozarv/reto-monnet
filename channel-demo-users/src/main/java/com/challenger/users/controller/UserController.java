package com.challenger.users.controller;

import com.challenger.users.api.UsersApi;
import com.challenger.users.model.User;
import com.challenger.users.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {

  private final UserService userService;

  @Override
  public ResponseEntity<List<User>> listUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }


}
