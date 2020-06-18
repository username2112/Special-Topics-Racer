package com.specialtopics.racer;

import com.oroarmor.core.Destructor;

import com.oroarmor.core.game.Game;
import com.specialtopics.racer.event.gamepause.GamePauseEvent;
import com.specialtopics.racer.event.gamepause.GamePauseEventListener;
import com.specialtopics.racer.event.gameclose.GameCloseEvent;
import com.specialtopics.racer.event.gameclose.GameCloseEventListener;

public class Racer extends Game<RacerInfo> implements GameCloseEventListener, GamePauseEventListener {
	private boolean paused = false;

	public Racer() {
		super(new RacerRenderer(getInfo()), new RacerLogic(getInfo()));

		addToGameCloseListeners();
		addToGamePauseListeners();

	}

	private static RacerInfo info;

	public static RacerInfo getInfo() {
		if (info == null) {
			info = new RacerInfo();
		}
		return info;
	}

	private boolean running = true;

	@Override
	public boolean isActive() {
		return running;
	}

	@Override
	public void setActive(boolean active) {
		running = active;
	}

	@Override
	public void processGameCloseEvent(GameCloseEvent event) {
		setActive(false);
	}

	@Override
	public Game<RacerInfo> run() {
		getGameGraphics().initialize();
		getGameLogic().initialize();

		long frameStart = System.currentTimeMillis();
		long frameTime = 1; // should prevent errors if dividing by time
		while (running) {
			if (!paused)
				getGameLogic().tick(frameTime / 1000f);
			getGameGraphics().render(frameTime / 1000f);

			frameTime = System.currentTimeMillis() - frameStart;
			frameStart = System.currentTimeMillis();
		}

		getGameGraphics().deinitialize();
		getGameLogic().deinitialize();

		Destructor.destroyAll();

		return this;
	}

	@Override
	public void processGamePauseEvent(GamePauseEvent event) {
		this.paused = !paused;

	}

}
