package org.sampleapp.controllers;

import org.sampleapp.SmallJavaWebappApplication;
import org.sampleapp.model.Trainer;
import org.sampleapp.util.Git;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shelajev on 24/07/16.
 */

@Controller
public class MainController {

  private static final Logger log = LoggerFactory.getLogger(SmallJavaWebappApplication.class);

  @Autowired ChallengeApp challengeApp;

  @RequestMapping("/")
  public String index() {
    return "tour";
  }

  @RequestMapping("/challenge")
  public String challenge(Model model) {
    log.info("Loading some of the trainers and their pokemon (even if they don't have any)");

    Page<Trainer> top10 = challengeApp.getTopTrainers();

    model.addAttribute("trainers", top10);
    return "challenge";
  }

  

  @RequestMapping("/revert")
  public String revert() {
    new Git().revert();
    return "redirect:/";
  }

}
