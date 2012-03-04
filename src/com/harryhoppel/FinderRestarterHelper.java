package com.harryhoppel;

import com.intellij.openapi.application.ApplicationActivationListener;
import com.intellij.openapi.wm.IdeFrame;

import java.io.IOException;

/**
 * @author vasiliy
 * Date: 04.03.12
 */
public class FinderRestarterHelper implements ApplicationActivationListener {
  @Override
  public void applicationActivated(IdeFrame ideFrame) {
    try {
      Runtime.getRuntime().exec("/usr/bin/killall Finder");
    } catch (IOException e) {
      // todo logging with some Intellij component
      e.printStackTrace();
    }
  }

  @Override
  public void applicationDeactivated(IdeFrame ideFrame) {}
}
