package com.specialtopics.racer;

import com.oroarmor.core.game.GameLogic;

public class RacerLogic implements GameLogic<RacerInfo> {

	private RacerInfo info;

	public RacerLogic(RacerInfo info) {
		this.info = info;
	}

	@Override
	public void initialize() {

		while (info.getPlayerCar() == null) {

		}
	}

	@Override
	public void tick(float updateTime) {
		info.getCamera().tick(updateTime);

		info.getPlayerCar().tick(updateTime);
		info.getPlayerCar().setCameraLocal(info.getCamera());

		info.getCurrentLevel().update(updateTime);

//		System.out.printf("Current Speed: %.2fm/s\n", info.getPlayerCar().getVelocityVector().length());
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
