/*
 * Copyright 2015, Cristiano Costantini
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.codejuicer.gwt.slimmize.client;

import com.google.gwt.core.client.EntryPoint;

import org.codejuicer.gwt.slimmize.client.api.WunitGameController;
import org.codejuicer.gwt.slimmize.client.api.WunitGameLog;
import org.codejuicer.gwt.slimmize.client.api.WunitGameStatus;
import org.codejuicer.gwt.slimmize.client.api.WunitUnit;

public class AppEntryPoint implements EntryPoint, WunitGameController {

  public static native void log(String msg) /*-{
                                            console.log(msg);
                                            }-*/;

  public static native void log(String msg, Object obj) /*-{
                                                        console.log(msg, obj);
                                                        }-*/;

  private WunitGameLog gameLogElement;
  private WunitGameStatus gameStatusElement;
  private WunitUnit unitAElement;
  private WunitUnit unitBElement;

  @Override
  public void onModuleLoad() {
    log("AppEntryPoint has loaded");

    initializeGui();

    gameStatusElement.setGameController(this);
  }

  @Override
  public void play1() {
    log("Todo... implement play1 callback");
  }

  @Override
  public void playAll() {
    log("Todo... implement playAll callback");
  }

  @Override
  public void reset() {
    log("Todo... implement reset callback");
  }

  @Override
  public void start() {
    log("Todo... implement start callback");
  }

  private native <T> T documentQuerySelector(String string) /*-{
                                                            return document.querySelector(string);
                                                            }-*/;

  private void initializeGui() {
    unitAElement = documentQuerySelector("#unit-a");
    unitBElement = documentQuerySelector("#unit-b");
    gameStatusElement = documentQuerySelector("#game-status");
    gameLogElement = documentQuerySelector("#game-log");

  }

}
