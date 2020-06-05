package com.specialtopics.racer.car;

import org.joml.Vector3f;
import org.joml.Vector4f;

import com.oroarmor.core.game.entity.Camera;
import com.oroarmor.core.opengl.Texture;
import com.oroarmor.util.OBJLoader;
import com.oroarmor.util.ResourceLoader;

public class Car1 extends Car {

	public Car1(Vector3f position, Vector3f rotation, Vector3f scale, float weight, Vector4f carColor) {
		super(position, rotation, scale, weight,
				OBJLoader.loadOBJ(ResourceLoader
						.loadFile(Class.class.getResourceAsStream("/com/specialtopics/racer/car/car1/car1.obj"))),
				new CarShader(), carColor, new Texture("./assets/com/specialtopics/racer/car/car1/car1.png"));
	}

	@Override
	public void setCameraLocal(Camera camera) {
		camera.getPosition().set(this.getPosition()).add(new Vector3f(9.5f, 10f, 3f));
	}

}
