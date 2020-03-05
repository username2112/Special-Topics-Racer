package com.specialtopics.racer;

import org.joml.Vector3f;

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
		info.getCamera().tick(updateTime);
		info.getCamera().setMaxSpeed(1);
		info.getCamera().addAcceleration(new Vector3f(0, /*-9.81f*/ 0, 0));
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
