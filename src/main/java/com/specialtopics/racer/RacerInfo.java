package com.specialtopics.racer;

import com.oroarmor.core.game.Camera;
import com.oroarmor.core.game.GameInfo;
import com.oroarmor.core.game.light.Sunlight;
import com.oroarmor.core.opengl.Renderer;
import com.specialtopics.racer.graphics.RacerDisplay;
import com.specialtopics.racer.level.Level;

public class RacerInfo implements GameInfo {
	private RacerDisplay racerDisplay;

	public synchronized RacerDisplay getRacerDisplay() {
		return racerDisplay;
	}

	public synchronized void setRacerDisplay(RacerDisplay racerDisplay) {
		this.racerDisplay = racerDisplay;
	}

	private Renderer racerRenderer;

	public synchronized Renderer getRacerRenderer() {
		return racerRenderer;
	}

	public synchronized void setRacerRenderer(Renderer racerRenderer) {
		this.racerRenderer = racerRenderer;
	}

	private Level currentLevel;

	public synchronized Level getCurrentLevel() {
		return currentLevel;
	}

	public synchronized void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}

	private Camera camera;
	private Sunlight sun;

	public synchronized Camera getCamera() {
		return camera;
	}

	public synchronized void setCamera(Camera camera) {
		this.camera = camera;
	}

	public synchronized Sunlight getSun() {
		return sun;
	}

	public synchronized void setSun(Sunlight sun) {
		this.sun = sun;
	}

}
