package com.specialtopics.racer;

import org.joml.Vector3f;

import com.oroarmor.core.game.GameRenderer;
import com.oroarmor.core.game.gui.shader.GUIShaders;
import com.oroarmor.core.openal.AudioMaster;
import com.oroarmor.core.opengl.Renderer;
import com.specialtopics.racer.car.Car;
import com.specialtopics.racer.event.gameclose.GameCloseEvent;
import com.specialtopics.racer.event.gameclose.GameCloseEventListener;
import com.specialtopics.racer.graphics.RacerDisplay;
import com.specialtopics.racer.gui.RacerGUI;
import com.specialtopics.racer.level.Level;
import com.specialtopics.racer.level.level1.Level1;
import com.specialtopics.racer.music.Radio;

public class RacerRenderer implements GameRenderer<RacerInfo> {

	private RacerInfo info;

	public RacerRenderer(RacerInfo info) {
		setGameInfo(info);
	}

	/**
	 * Initalize all GLFW/OpenGL/OpenAL objects here.
	 */
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

		Car playerCar = new Car(new Vector3f(200f, 0, 200f), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), 10);
		info.setPlayerCar(playerCar);

		RacerGUI gui = new RacerGUI(racerDisplay);
		info.setGUI(gui);

		AudioMaster.initialize();

		Radio radio = new Radio();
		info.setRadio(radio);
	}

	@Override
	public void render(float renderTime) {
		info.getRacerDisplay().clear();

		if (info.isStarted()) {
			info.getCurrentLevel().render(info.getRacerRenderer(), info.getCamera(), info.getRacerDisplay(),
					info.getSun());
		} else {
			GUIShaders.updateShaderView(info.getRacerDisplay().getOrthoViewModel());
			info.getGUI().render(info.getRacerRenderer());
		}

		if (info.getRadio().isFinished()) {
			info.getRadio().playSound();
		}

		info.getRacerDisplay().render();
		if (info.getRacerDisplay().shouldClose()) {
			GameCloseEventListener.processAllGameCloseEvent(new GameCloseEvent());
		}
	}

	@Override
	public void deinitialize() {
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
