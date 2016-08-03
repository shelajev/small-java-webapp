package org.sampleapp.controllers.api;

import org.sampleapp.controllers.api.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sampleapp.SmallJavaWebappApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

/**
 * Created by shelajev on 22/07/16.
 */
@Controller()
public class Emails {

  private static final Logger log = LoggerFactory.getLogger(SmallJavaWebappApplication.class);

  @Value("${smalljavawebapp.results.event}")
  private String eventName;

  @Value("${smalljavawebapp.results.dir}")
  private String resultsDir;

  @RequestMapping(value="/success", method=RequestMethod.GET)
  public String greetingForm(Model model) {
    model.addAttribute("email", new Email());
    return "emails/form";
  }

  @RequestMapping(value = "emails/save", method = RequestMethod.POST)
  public String save(@ModelAttribute Email email, Model model) {

    try {
      Files.write(Paths.get(getResultFile()), Collections.singletonList(email.name + "," + email.email), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
    catch (IOException e) {
      log.error("Cannot store the result: " + email.name + "," + email.email , e);
    }
    return "redirect:/";
  }

  private String getResultFile() {
    if(resultsDir != null && !resultsDir.isEmpty()) {
      return resultsDir + "/" + eventName + ".txt";
    }
    return "results/" + eventName + ".txt";
  }

}
