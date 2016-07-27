package org.zeroturnaround.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zeroturnaround.SmallJavaWebappApplication;
import org.zeroturnaround.util.Git;

/**
 * Created by shelajev on 24/07/16.
 */

@Controller
public class MainController {

  private static final Logger log = LoggerFactory.getLogger(SmallJavaWebappApplication.class);

  @RequestMapping("/")
  public String index() {
    return "tour";
  }

  @RequestMapping("/challenge")
  public String challenge() {
    return "challenge";
  }

  @RequestMapping("/success")
  public String success() {
    return "emails/form";
  }


  @RequestMapping("/revert")
  public String revert() {
    new Git().revert();
    return "redirect:/";
  }


}
