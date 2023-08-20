package com.junction.junckit.domain.user.controller;

import com.junction.junckit.domain.user.entity.User;
import com.junction.junckit.domain.user.sevice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @GetMapping("")
  @ResponseBody
  public User getUserInfo(@RequestParam Long id) {
    return userService.getUserInfo(id);
  }
}
