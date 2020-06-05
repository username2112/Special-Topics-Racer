package com.specialtopics.racer.level;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import com.oroarmor.core.game.entity.Camera;
import com.oroarmor.core.game.entity.Entity;
import com.oroarmor.core.game.light.Sunlight;
import com.oroarmor.core.opengl.Mesh;
import com.oroarmor.core.opengl.Renderer;
import com.oroarmor.core.opengl.Texture;
import com.specialtopics.racer.graphics.RacerDisplay;

public abstract class Level extends Entity {
	private Mesh levelMesh;
	private Texture levelTexture;
	private LevelShader shader;

	public Level(Mesh levelMesh, Texture levelTexture, LevelShader shader) {
		super(new Vector3f(), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1));
		this.levelMesh = levelMesh;
		this.levelTexture = levelTexture;
		this.shader = shader;
	}

	public LevelShader getShader() {
		return shader;
	}

	public void setShader(LevelShader shader) {
		this.shader = shader;
	}

	public Mesh getLevelMesh() {
		return levelMesh;
	}

	public void setLevelMesh(Mesh levelMesh) {
		this.levelMesh = levelMesh;
	}

	public Texture getLevelTexture() {
		return levelTexture;
	}

	public void setLevelTexture(Texture levelTexture) {
		this.levelTexture = levelTexture;
	}

	public void render(Renderer renderer, Camera camera, RacerDisplay display, Sunlight sun) {
		prepareShader(camera, display, sun);
		levelMesh.render(renderer, shader);
	}

	private void prepareShader(Camera camera, RacerDisplay display, Sunlight sun) {
		Matrix4f MV = display.getPerspectiveViewModel(70).mul(camera.getModelMatrix());
		setModelMatrix();
		Matrix4f P = getModelMatrix();

		shader.setUniformMat4f("u_MV", MV);
		shader.setUniformMat4f("u_P", P);
		shader.setSun(sun);

		shader.setMainTexture(levelTexture);
	}

	@Override
	public void update(float delta) {
		positionVector.add(new Vector3f(0));
	}

}
