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
import com.oroarmor.core.glfw.event.key.KeyStatus;
import com.oroarmor.core.glfw.event.key.hold.KeyHoldEvent;
import com.oroarmor.core.glfw.event.key.press.KeyPressEvent;
import com.oroarmor.core.glfw.event.key.release.KeyReleaseEvent;
import com.oroarmor.core.opengl.Mesh;
import com.oroarmor.core.opengl.Renderer;
import com.oroarmor.core.opengl.Texture;
import com.specialtopics.racer.graphics.RacerDisplay;

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

		addToKeyListeners();
	}

	@Override
	public void update(float delta) {
		drag(0.3f, 0.3f, 0.3f);

		if (KeyStatus.isKeyDown(Key.LEFT)) {
			rotationVector.add(new Vector3f(0, -0.1f, 0));
			velocityVector.rotateY(-0.1f);
		} else if (KeyStatus.isKeyDown(Key.RIGHT)) {
			rotationVector.add(new Vector3f(0, 0.1f, 0));
			velocityVector.rotateY(0.1f);
		}

		if (KeyStatus.isKeyDown(Key.W)) {
			accelerateLocalXZ(new Vector2f(0, 1f));
		} else if (KeyStatus.isKeyDown(Key.S)) {
			accelerateLocalXZ(new Vector2f(0, -1f));
		}

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
		Matrix4f MV = display.getPerspectiveViewModel(70).mul(camera.getModelMatrix());
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

	}

	@Override
	public boolean isActive() {
		return true;
	}

	@Override
	public void setActive(boolean active) {
	}

}