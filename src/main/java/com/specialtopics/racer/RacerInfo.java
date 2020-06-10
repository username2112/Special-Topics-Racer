package com.specialtopics.racer;

import org.joml.Vector3f;
import org.joml.Vector4f;

import com.oroarmor.core.game.GameInfo;
import com.oroarmor.core.game.entity.Camera;
import com.oroarmor.core.game.light.Sunlight;
import com.oroarmor.core.opengl.Renderer;
import com.specialtopics.racer.car.Car;
import com.specialtopics.racer.graphics.RacerDisplay;
import com.specialtopics.racer.gui.RacerGUI;
import com.specialtopics.racer.level.Level;

public class RacerInfo implements GameInfo {

	private RacerDisplay racerDisplay;
	private Renderer racerRenderer;

	private Level currentLevel;

	private Camera camera;
	private Sunlight sun;

	private Car playerCar;

	private long startTime;
	private RacerGUI gui;
	private boolean started = false;

	/**
	 * Initialize objects that do *not* require a GLFW/OpenGL/OpenAL context here.
	 */
	public RacerInfo() {
		camera = new Camera(new Vector3f(0, 0, 0), new Vector3f(0, (float) (Math.PI / 2), 0));
		sun = new Sunlight(new Vector3f(0, -1, 0), new Vector4f(1, 1, 1, 1));
		setStartTime(0);
	}

	public synchronized Camera getCamera() {
		return camera;
	}

	public synchronized Level getCurrentLevel() {
		return currentLevel;
	}

	public synchronized RacerDisplay getRacerDisplay() {
		return racerDisplay;
	}

	public synchronized Renderer getRacerRenderer() {
		return racerRenderer;
	}

	public synchronized Sunlight getSun() {
		return sun;
	}

	public synchronized void setCamera(Camera camera) {
		this.camera = camera;
	}

	public synchronized void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}

	public synchronized void setRacerDisplay(RacerDisplay racerDisplay) {
		this.racerDisplay = racerDisplay;
	}

	public synchronized void setRacerRenderer(Renderer racerRenderer) {
		this.racerRenderer = racerRenderer;
	}

	public synchronized void setSun(Sunlight sun) {
		this.sun = sun;
	}

	public synchronized Car getPlayerCar() {
		return playerCar;
	}

	public synchronized void setPlayerCar(Car playerCar) {
		this.playerCar = playerCar;
	}

	public synchronized long getStartTime() {
		return startTime;
	}

	public synchronized void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public synchronized void initalizeTimer() {
		startTime = System.currentTimeMillis();
	}

	public void setGUI(RacerGUI gui) {
		this.gui = gui;
	}

	public RacerGUI getGUI() {
		return this.gui;
	}

	public boolean isStarted() {
		return this.started;
	}

	public void startGame() {
		this.started = true;
	}

}
