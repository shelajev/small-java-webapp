package org.zeroturnaround.controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zeroturnaround.SmallJavaWebappApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

/**
 * Created by shelajev on 22/07/16.
 */
@Controller(value = "/emails")
public class Emails {

  private static final Logger log = LoggerFactory.getLogger(SmallJavaWebappApplication.class);

  @Value("${smalljavawebapp.results.event}")
  private String eventName;

  @Value("${smalljavawebapp.results.dir}")
  private String resultsDir;

  @RequestMapping(value = "/emails/save", method = RequestMethod.GET)
  public String save(@RequestParam(value="name", defaultValue="") String name, @RequestParam(value="email", defaultValue="") String email) {
    try {
      Files.write(Paths.get(getResultFile()), Collections.singletonList(name + "," + email), StandardOpenOption.APPEND);
    }
    catch (IOException e) {
      log.error("Cannot store the result: " + name + "," + email , e);
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
