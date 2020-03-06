package com.specialtopics.racer.level.level1;

import org.joml.Vector3f;

import com.oroarmor.core.opengl.Texture;
import com.oroarmor.util.OBJLoader;
import com.oroarmor.util.ResourceLoader;
import com.specialtopics.racer.level.Level;
import com.specialtopics.racer.level.LevelShader;

public class Level1 extends Level {

	public Level1() {
		super(OBJLoader.loadOBJ(ResourceLoader
				.loadFile(Class.class.getResourceAsStream("/com/specialtopics/racer/level/level1/track.obj"))),
				new Texture("./assets/com/specialtopics/racer/level/level1/Track.png"), new LevelShader());

		this.positionVector = new Vector3f(0, -100, 0);
		this.setModelMatrix();
	}

	@Override
	public void update(float delta) {

	}

}
