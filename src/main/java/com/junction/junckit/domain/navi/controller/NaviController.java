package com.junction.junckit.domain.navi.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/navi")
public class NaviController {

  @GetMapping("/status")
  public String getNaviStatus(
    @RequestParam Double x, Double y
  ) throws InterruptedException {
    KakaoStatus();
    Thread.sleep(9000);
    return "Good";
  }

  @Scheduled(fixedRate = 3000)
  public void KakaoStatus() {
    log.info("PING");
  }
}
