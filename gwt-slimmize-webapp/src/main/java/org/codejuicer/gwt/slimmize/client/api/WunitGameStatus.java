package org.codejuicer.gwt.slimmize.client.api;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface WunitGameStatus {

  @JsProperty
  void setSide(String side);

  @JsProperty
  void setPhase(String phase);

  @JsProperty
  void setTurn(Integer turn);

  @JsProperty
  void setDistance(Double distance);

  @JsProperty
  void setSideASize(Integer sideASize);

  @JsProperty
  void setSideBSize(Integer sideBSize);

  @JsProperty
  void setSideAName(String factionName);

  @JsProperty
  void setSideBName(String factionName);

  @JsProperty
  void setGameController(WunitGameController controller);

}
