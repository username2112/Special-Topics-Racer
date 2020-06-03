package com.specialtopics.racer.car;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import com.oroarmor.core.game.entity.Camera;
import com.oroarmor.core.game.entity.physics.PhysicsEntity;
import com.oroarmor.core.game.light.Sunlight;
import com.oroarmor.core.glfw.event.key.Key;
import com.oroarmor.core.glfw.event.key.KeyEventListener;
import com.oroarmor.core.glfw.event.key.hold.KeyHoldEvent;
import com.oroarmor.core.glfw.event.key.press.KeyPressEvent;
import com.oroarmor.core.glfw.event.key.release.KeyReleaseEvent;
import com.oroarmor.core.opengl.Mesh;
import com.oroarmor.core.opengl.Renderer;
import com.oroarmor.core.opengl.Texture;
import com.specialtopics.racer.graphics.RacerDisplay;

import javafx.scene.paint.Color;

public abstract class Car extends PhysicsEntity implements KeyEventListener {

	private Mesh carMesh;
	private CarShader shader;
	private Vector4f carColor;
	private Texture carTexture;

	public Car(Vector3f position, Vector3f rotation, Vector3f scale, float weight, Mesh carMesh, CarShader shader,
			Vector4f carColor, Texture carTexture) {
		super(position, rotation, scale, weight);
		this.carMesh = carMesh;
		this.shader = shader;
		this.carColor = carColor;
		this.carTexture = carTexture;

		this.addToKeyListeners();
	}

	double val = 0;

	@Override
	public void update(float delta) {
		carColor = new Vector4f((float) Color.hsb(val, 1, 1).getRed(), (float) Color.hsb(val, 1, 1).getGreen(),
				(float) Color.hsb(val, 1, 1).getBlue(), 1);

		val += 0.005;

		rotationVector = rotationVector.rotateY((float) val / 10);
	}

	public void render(Renderer renderer, Camera camera, RacerDisplay display, Sunlight sun) {
		prepareShader(camera, display, sun, carColor);
		carMesh.render(renderer, shader);
	}

	public Mesh getCarMesh() {
		return carMesh;
	}

	public void setCarMesh(Mesh carMesh) {
		this.carMesh = carMesh;
	}

	public CarShader getShader() {
		return shader;
	}

	public void setShader(CarShader shader) {
		this.shader = shader;
	}

	public Vector4f getCarColor() {
		return carColor;
	}

	public void setCarColor(Vector4f carColor) {
		this.carColor = carColor;
	}

	public Texture getCarTexture() {
		return carTexture;
	}

	public void setCarTexture(Texture carTexture) {
		this.carTexture = carTexture;
	}

	public void prepareShader(Camera camera, RacerDisplay display, Sunlight sun, Vector4f color) {
		Matrix4f MV = display.getPerspectiveViewModel(100).mul(camera.getModelMatrix());
		setModelMatrix();
		Matrix4f P = getModelMatrix();

		getShader().setUniformMat4f("u_MV", MV);
		getShader().setUniformMat4f("u_P", P);
		getShader().setSun(sun);

		getShader().setMainTexture(carTexture);
		getShader().setUniform4f("u_carColor", color);
	}

	public abstract void setCameraLocal(Camera camera);

	@Override
	public void processKeyReleasedEvent(KeyReleaseEvent event) {

	}

	@Override
	public void processKeyHeldEvent(KeyHoldEvent event) {

	}

	@Override
	public void processKeyPressedEvent(KeyPressEvent event) {
		if (event.key == Key.W) {
			this.accelerateLocalXZ(new Vector2f(0.01f, 0));
			System.out.println(positionVector);
		} else if (event.key == Key.S) {
			this.accelerateLocalXZ(new Vector2f(-0.01f, 0));
			System.out.println(positionVector);
		}
	}

	@Override
	public boolean isActive() {
		return true;
	}

	@Override
	public void setActive(boolean active) {
	}

}