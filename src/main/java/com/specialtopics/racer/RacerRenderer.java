package com.specialtopics.racer;

import com.oroarmor.core.Destructor;
import com.oroarmor.core.game.GameRenderer;
import com.specialtopics.racer.event.gameclose.GameCloseEvent;
import com.specialtopics.racer.event.gameclose.GameCloseEventListener;
import com.specialtopics.racer.graphics.RacerDisplay;

public class RacerRenderer implements GameRenderer<RacerInfo> {

	private RacerInfo info;

	public RacerRenderer(RacerInfo info) {
		setGameInfo(info);
	}

	@Override
	public void initialize() {
		RacerDisplay racerDisplay = new RacerDisplay();
		racerDisplay.setClearColor(1, 0, 0, 1);
		info.setRacerDisplay(racerDisplay);
	}

	@Override
	public void render(float renderTime) {
		info.getRacerDisplay().clear();
		info.getRacerDisplay().render();
		info.getRacerDisplay().setClearColor(1, 0, 0, 1);
		if (info.getRacerDisplay().shouldClose())
			GameCloseEventListener.processAllGameCloseEvent(new GameCloseEvent());
	}

	@Override
	public void deinitialize() {
		Destructor.destroyAll();
		info.getRacerDisplay().end();
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
