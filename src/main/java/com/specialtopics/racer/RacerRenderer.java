package com.specialtopics.racer;

import org.joml.Vector3f;
import org.joml.Vector4f;

import com.oroarmor.core.Destructor;
import com.oroarmor.core.game.Camera;
import com.oroarmor.core.game.GameRenderer;
import com.oroarmor.core.game.light.Sunlight;
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
		Camera camera = new Camera(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0));
		info.setCamera(camera);

		Sunlight sun = new Sunlight(new Vector3f(0, -1, 0), new Vector4f(1, 1, 1, 1));

		info.setSun(sun);

		RacerDisplay racerDisplay = new RacerDisplay();
		racerDisplay.setClearColor(0, 0, 0, 1);
		info.setRacerDisplay(racerDisplay);

		Renderer renderer = new Renderer();
		info.setRacerRenderer(renderer);

		Level currentLevel = new Level1();
		info.setCurrentLevel(currentLevel);
	}

	@Override
	public void render(float renderTime) {
		info.getRacerDisplay().clear();
		info.getRacerDisplay().render();

		info.getCurrentLevel().prepareShader(info.getCamera(), info.getRacerDisplay(), info.getSun());
		info.getCurrentLevel().render(info.getRacerRenderer());

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
