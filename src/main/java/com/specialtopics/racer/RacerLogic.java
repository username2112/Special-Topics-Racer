package com.specialtopics.racer;

import com.oroarmor.core.game.GameLogic;

public class RacerLogic implements GameLogic<RacerInfo> {

	private RacerInfo info;

	public RacerLogic(RacerInfo info) {
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
	public RacerInfo getGameInfo() {
		return info;
	}

	@Override
	public void setGameInfo(RacerInfo info) {
		this.info = info;
	}

}
