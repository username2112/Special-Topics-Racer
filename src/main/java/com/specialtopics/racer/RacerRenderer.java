package com.specialtopics.racer;

import com.oroarmor.core.Destructor;
import com.oroarmor.core.game.GameRenderer;
import com.oroarmor.core.opengl.Renderer;
import com.specialtopics.racer.event.gameclose.GameCloseEvent;
import com.specialtopics.racer.event.gameclose.GameCloseEventListener;
import com.specialtopics.racer.graphics.RacerDisplay;
import com.specialtopics.racer.level.Level;
import com.specialtopics.racer.level.level1.Level1;

public class RacerRenderer implements GameRenderer<RacerInfo> {

	private RacerInfo info;

	public RacerRenderer(RacerInfo info) {
		setGameInfo(info);
	}

	@Override
	public void initialize() {
		RacerDisplay racerDisplay = new RacerDisplay();
		racerDisplay.setClearColor(0, 0, 0, 1);
		racerDisplay.enableTransparency();
		info.setRacerDisplay(racerDisplay);

		Renderer renderer = new Renderer();
		info.setRacerRenderer(renderer);

		Level currentLevel = new Level1();
		info.setCurrentLevel(currentLevel);
	}

	@Override
	public void render(float renderTime) {
		info.getRacerDisplay().clear();

		info.getCurrentLevel().prepareShader(info.getCamera(), info.getRacerDisplay(), info.getSun());
		info.getCurrentLevel().render(info.getRacerRenderer());

		info.getRacerDisplay().render();

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
