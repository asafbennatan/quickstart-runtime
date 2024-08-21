package com.wizzdi.asaf.runtime.flows;

import com.wizzdi.asaf.runtime.security.UserSecurityContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MyFlow {

  @Scheduled(fixedDelay = 15000)
  public void runSchedule() {
    run(null);
  }

  public boolean run(UserSecurityContext securityContext) {

    return true;
  }
}
