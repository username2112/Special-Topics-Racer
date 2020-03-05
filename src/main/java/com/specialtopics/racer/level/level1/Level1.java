package com.specialtopics.racer.level.level1;

import org.joml.Vector3f;

import com.oroarmor.core.opengl.Mesh;
import com.oroarmor.core.opengl.Texture;
import com.oroarmor.core.opengl.VertexBufferLayout;
import com.specialtopics.racer.level.Level;
import com.specialtopics.racer.level.LevelShader;

public class Level1 extends Level {

	public Level1() {
		super(new Mesh(new float[] { 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0 }, new int[] { 0, 1, 2, 2, 3, 0 },
				new VertexBufferLayout().pushFloats(3)),
				// OBJLoader.loadOBJ(ResourceLoader.loadFile(Class.class.getResourceAsStream("/com/specialtopics/racer/level/level1/track.obj"))),
				new Texture("/com/specialtopics/racer/level/level1/Track.png"), new LevelShader());

		this.scaleVector = new Vector3f(10000, 1, 10000);
		this.positionVector = new Vector3f(0, -100, 0);
		this.setModelMatrix();
	}

	@Override
	public void update(float delta) {

	}

}
