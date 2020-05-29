package com.specialtopics.racer.car;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import com.oroarmor.core.game.entity.Camera;
import com.oroarmor.core.game.entity.physics.PhysicsEntity;
import com.oroarmor.core.game.light.Sunlight;
import com.oroarmor.core.opengl.Mesh;
import com.oroarmor.core.opengl.Renderer;
import com.oroarmor.core.opengl.Texture;
import com.specialtopics.racer.graphics.RacerDisplay;

import javafx.scene.paint.Color;

public abstract class Car extends PhysicsEntity {

	private Mesh carMesh;
	private CarShader shader;
	private Vector4f carColor;
	private Texture carTexture;

	public Car(final Vector3f position, final Vector3f rotation, final Vector3f scale, final float weight,
			final Mesh carMesh, final CarShader shader, final Vector4f carColor, final Texture carTexture) {
		super(position, rotation, scale, weight);
		this.carMesh = carMesh;
		this.shader = shader;
		this.carColor = carColor;
		this.carTexture = carTexture;
	}

	double val = 0;

	@Override
	public void update(final float delta) {
		carColor = new Vector4f((float) Color.hsb(val, 1, 1).getRed(), (float) Color.hsb(val, 1, 1).getGreen(),
				(float) Color.hsb(val, 1, 1).getBlue(), 1);

		val += 0.5;

		rotationVector = rotationVector.rotateY((float) val / 10);

		addAcceleration(new Vector3f(0, -1, 0));
	}

	public void render(final Renderer renderer, final Camera camera, final RacerDisplay display, final Sunlight sun) {
		update(0);

		prepareShader(camera, display, sun, carColor);
		carMesh.render(renderer, shader);
	}

	public Mesh getCarMesh() {
		return carMesh;
	}

	public void setCarMesh(final Mesh carMesh) {
		this.carMesh = carMesh;
	}

	public CarShader getShader() {
		return shader;
	}

	public void setShader(final CarShader shader) {
		this.shader = shader;
	}

	public Vector4f getCarColor() {
		return carColor;
	}

	public void setCarColor(final Vector4f carColor) {
		this.carColor = carColor;
	}

	public Texture getCarTexture() {
		return carTexture;
	}

	public void setCarTexture(final Texture carTexture) {
		this.carTexture = carTexture;
	}

	public void prepareShader(final Camera camera, final RacerDisplay display, final Sunlight sun,
			final Vector4f color) {
		final Matrix4f MV = display.getPerspectiveViewModel(70).mul(camera.getModelMatrix());
		setModelMatrix();
		final Matrix4f P = getModelMatrix();

		getShader().setUniformMat4f("u_MV", MV);
		getShader().setUniformMat4f("u_P", P);
		getShader().setSun(sun);

		getShader().setMainTexture(carTexture);
		getShader().setUniform4f("u_carColor", color);
	}

}