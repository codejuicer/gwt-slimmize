package org.codejuicer.gwt.slimmize.client.api;

import com.google.gwt.core.client.js.JsType;

@JsType
public interface WunitResultLog {

  WunitResultLog addKill(String name);

  WunitResultLog addWound(String name, int damage, int actual);
}
