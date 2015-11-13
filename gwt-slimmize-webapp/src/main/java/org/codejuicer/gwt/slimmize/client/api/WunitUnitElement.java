package org.codejuicer.gwt.slimmize.client.api;

import com.google.gwt.core.client.js.JsType;

@JsType
public abstract class WunitUnitElement {

  public String name;
  public int qty;
  public int ws;
  public int bs;
  public int s;
  public int t;
  public int w;
  public int i;
  public int a;
  public int ld;
  public String save;
  public String type;
  
  public abstract void addWargear(String id, String wargearName);
  public abstract void addRule(String id, String ruleName);

}
