package com.specialtopics.racer.car;

import org.joml.Vector2f;
import org.joml.Vector3f;

import com.oroarmor.core.game.entity.Camera;
import com.oroarmor.core.game.entity.physics.PhysicsEntity;
import com.oroarmor.core.glfw.event.key.Key;
import com.oroarmor.core.glfw.event.key.KeyEventListener;
import com.oroarmor.core.glfw.event.key.KeyStatus;
import com.oroarmor.core.glfw.event.key.hold.KeyHoldEvent;
import com.oroarmor.core.glfw.event.key.press.KeyPressEvent;
import com.oroarmor.core.glfw.event.key.release.KeyReleaseEvent;

public class Car extends PhysicsEntity implements KeyEventListener {

	public Car(Vector3f position, Vector3f rotation, Vector3f scale, float weight) {
		super(position, rotation, scale, weight);

		addToKeyListeners();
	}

	@Override
	public void update(float delta) {
		drag(0.3f, 0.3f, 0.3f);

		if (KeyStatus.isKeyDown(Key.A) || KeyStatus.isKeyDown(Key.LEFT)) {
			rotationVector.add(new Vector3f(0, -0.1f, 0));
			velocityVector.rotateY(-0.1f);
		} else if (KeyStatus.isKeyDown(Key.D) || KeyStatus.isKeyDown(Key.RIGHT)) {
			rotationVector.add(new Vector3f(0, 0.1f, 0));
			velocityVector.rotateY(0.1f);
		}

		if (KeyStatus.isKeyDown(Key.W) || KeyStatus.isKeyDown(Key.UP)) {
			accelerateLocalXZ(new Vector2f(0, 1f));
		} else if (KeyStatus.isKeyDown(Key.S) || KeyStatus.isKeyDown(Key.DOWN)) {
			drag(0.95f, 0.95f, 0.95f);
		}

	}

	public void setCameraLocal(Camera camera) {
		camera.getPosition().set(getPosition()).add(new Vector3f(9.5f, 10f, 3f));
		camera.getRotation().set(rotationVector.negate(new Vector3f()));
	}

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