package org.codejuicer.gwt.slimmize.client.api;

import com.google.gwt.core.client.js.JsType;

@JsType
public interface WunitGameLog {

  WunitDiceLog appendFightLog(String side, int i, int attackerWs, int targetWs);

  WunitDiceLog appendMovementLog(String side, Double distance, boolean charge, boolean run,
      boolean advance, boolean stationary, boolean retreat);

  WunitVsRollsLog appendPreStartSequenceLog(String deployWinner, String deployFirst,
      String startFirst);

  WunitDiceLog appendWoundLog(String side, int strength, int toughness);

  WunitDiceLog appendShootLog(String side, int bs, String wargearId,
      String wargearName, Boolean overwatch);

  void clear();

  void startNewPhase(String faction, Integer turn, String phase);

  WunitDiceLog appendSaveLog(String side, int save, boolean armor, boolean cover,
      boolean invulerable);

  WunitResultLog appendResultLog(String side, Integer integer);

  void appendEndGameLog(String winner);

}
