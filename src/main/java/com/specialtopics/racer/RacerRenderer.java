package com.specialtopics.racer;

import com.oroarmor.core.Destructor;
import com.oroarmor.core.game.GameRenderer;
import com.oroarmor.core.opengl.Mesh;
import com.oroarmor.core.opengl.Renderer;
import com.oroarmor.core.opengl.Shader;
import com.oroarmor.util.OBJLoader;
import com.oroarmor.util.ResourceLoader;
import com.specialtopics.racer.event.gameclose.GameCloseEvent;
import com.specialtopics.racer.event.gameclose.GameCloseEventListener;
import com.specialtopics.racer.graphics.RacerDisplay;
import com.specialtopics.racer.level.Level;
import com.specialtopics.racer.level.level1.Level1;

public class RacerRenderer implements GameRenderer<RacerInfo> {

	private RacerInfo info;

	private Mesh testMesh;
	private Shader testShader;

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

		testMesh = OBJLoader.loadOBJ(ResourceLoader.loadFile(Class.class.getResourceAsStream("/test/square.obj")));

		testShader = new Shader(ResourceLoader.loadFile(Class.class.getResourceAsStream("/test/weirdvs.vs")),
				ResourceLoader.loadFile(Class.class.getResourceAsStream("/test/weirdfs.fs")));
	}

	@Override
	public void render(float renderTime) {
		info.getRacerDisplay().clear();

//		info.getCurrentLevel().render(info.getRacerRenderer(), info.getCamera(), info.getRacerDisplay(), info.getSun());

		testMesh.render(info.getRacerRenderer(), testShader);

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
