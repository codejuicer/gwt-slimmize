package org.codejuicer.gwt.slimmize.client.api;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface WunitUnit {

  void clear();

  WunitUnitElement addNew();

  @JsProperty
  String getName();

  @JsProperty
  void setName(String x);

}
