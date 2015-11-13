package org.codejuicer.gwt.slimmize.client.api;

import com.google.gwt.core.client.js.JsType;

@JsType
public interface WunitDiceLog {

  WunitDiceLog addDice(int score, boolean success, boolean fail, boolean rerolled);
}
