package org.codejuicer.gwt.slimmize.client.api;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface WunitVsRollsLog {

  @JsProperty
  WunitDiceLog getFactionARolls();

  @JsProperty
  WunitDiceLog getFactionBRolls();
}
