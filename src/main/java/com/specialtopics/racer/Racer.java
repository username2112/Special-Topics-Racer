package com.specialtopics.racer;

import com.oroarmor.core.game.Game;
import com.specialtopics.racer.event.gameclose.GameCloseEvent;
import com.specialtopics.racer.event.gameclose.GameCloseEventListener;

public class Racer extends Game<RacerInfo> implements GameCloseEventListener {
	public Racer() {
		super(new RacerRenderer(getInfo()), new RacerLogic(getInfo()));

		this.addToGameCloseListeners();
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
		this.running = active;
	}

	@Override
	public void processGameCloseEvent(GameCloseEvent event) {
		this.setActive(false);
	}

	@Override
	public Game<RacerInfo> run() {
		this.getGameGraphics().initialize();
		this.getGameLogic().initialize();

		long frameStart = System.currentTimeMillis();
		long frameTime = 1; // should prevent errors if dividing by time
		while (running) {
			this.getGameLogic().tick(frameTime / 1000f);
			this.getGameGraphics().render(frameTime / 1000f);

			frameTime = System.currentTimeMillis() - frameStart;
			frameStart = System.currentTimeMillis();
		}

		this.getGameGraphics().deinitialize();
		this.getGameLogic().deinitialize();

		return this;
	}

}
