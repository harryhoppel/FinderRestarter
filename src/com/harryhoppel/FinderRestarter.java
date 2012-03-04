package com.harryhoppel;

import com.intellij.openapi.application.ApplicationActivationListener;
import com.intellij.openapi.application.impl.ApplicationImpl;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

/**
 * @author vasiliy
 * Date: 04.03.12
 */
public class FinderRestarter implements ApplicationComponent {
  private final ApplicationImpl application;

  public FinderRestarter(ApplicationImpl application) {
    this.application = application;
  }

  public void initComponent() {
    if (System.getProperty("os.name").startsWith("Mac")) {
      application.getMessageBus().connect().subscribe(ApplicationActivationListener.TOPIC, new FinderRestarterHelper());
    }
  }

  public void disposeComponent() {}

  @NotNull
  public String getComponentName() {
    return "FinderRestarter";
  }
}
