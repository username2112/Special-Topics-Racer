package com.specialtopics.racer.car;

import org.joml.Vector3f;
import org.joml.Vector4f;

import com.oroarmor.core.game.entity.Camera;

public class Car2 extends Car {

	public Car2(Vector3f position, Vector3f rotation, Vector3f scale, float weight, Vector4f carColor) {
		super(position, rotation, scale, weight, null, null, carColor, null);
//		super(position, rotation, scale, weight,
//				OBJLoader.loadOBJ(ResourceLoader
//						.loadFile(Class.class.getResourceAsStream("com/specialtopics/racer/car/car2/car2.obj"))),
//				new CarShader(), carColor, new Texture("./assets/com/specialtopics/racer/car/car2/car2.png"));
	}

	@Override
	public void setCameraLocal(Camera camera) {

	}

}
