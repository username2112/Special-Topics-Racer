package com.specialtopics.racer;

import com.oroarmor.core.game.GameInfo;
import com.oroarmor.core.game.GameRenderer;

public class RacerRenderer implements GameRenderer {

	private GameInfo info;

	public RacerRenderer(RacerInfo info) {
		setGameInfo(info);
	}

	@Override
	public void initialize() {

	}

	@Override
	public void render(float renderTime) {

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
