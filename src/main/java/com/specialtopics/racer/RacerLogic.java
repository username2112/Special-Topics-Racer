package com.specialtopics.racer;

import com.oroarmor.core.game.GameInfo;
import com.oroarmor.core.game.GameLogic;

public class RacerLogic implements GameLogic {

	private GameInfo info;

	private RacerLogic(RacerInfo info) {
		this.info = info;
	}

	@Override
	public void initialize() {

	}

	@Override
	public void tick(float updateTime) {

	}

	@Override
	public void deinitialize() {

	}

	@Override
	public GameInfo getGameInfo() {
		return info;
	}

	@Override
	public void setGameInfo(GameInfo info) {
		this.info = info;
	}

}
