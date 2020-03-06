package com.specialtopics.racer;

import com.oroarmor.core.game.Game;
import com.specialtopics.racer.event.gameclose.GameCloseEvent;
import com.specialtopics.racer.event.gameclose.GameCloseEventListener;

public class Racer extends Game<RacerInfo> implements GameCloseEventListener {
	public Racer(RacerRenderer gameGraphics, RacerLogic gameLogic) {
		super(gameGraphics, gameLogic);
		this.addToGameCloseListeners();
	}

	@Override
	public boolean isActive() {
		return true;
	}

	@Override
	public void setActive(boolean active) {
		return; // cannot be set inactive
	}

	@Override
	public void processGameCloseEvent(GameCloseEvent event) {
		this.getLogicThread().setActive(false);
		this.getRenderThread().setActive(false);
	}
}
