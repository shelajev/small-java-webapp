package org.sampleapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sampleapp.SmallJavaWebappApplication;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.slf4j.Slf4jStream;

/**
 * Created by shelajev on 25/07/16.
 */
public class Git {

  private static final Logger log = LoggerFactory.getLogger(SmallJavaWebappApplication.class);

  public void revert() {
    try {
      // only uncomment when you commit all the local changes. Otherwise you might lose them
      new ProcessExecutor().command("git", "reset", "--hard")
//      new ProcessExecutor().command("pwd")
        .redirectOutput(Slf4jStream.of(log).asInfo())
        .execute();
    }
    catch (Exception e) {
      log.error("Cannot revert: " + e.getMessage(), e);
    }
  }
}
