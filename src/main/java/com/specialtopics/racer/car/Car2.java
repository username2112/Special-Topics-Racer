package com.specialtopics.racer.car;

import org.joml.Vector3f;
import org.joml.Vector4f;

import com.oroarmor.core.opengl.Texture;
import com.oroarmor.util.OBJLoader;
import com.oroarmor.util.ResourceLoader;

public class Car2 extends Car {

	public Car2(Vector3f position, Vector3f rotation, Vector3f scale, float weight, Vector4f carColor) {
		super(position, rotation, scale, weight,
				OBJLoader.loadOBJ(ResourceLoader
						.loadFile(Class.class.getResourceAsStream("com/specialtopics/racer/car/car2/car2.obj"))),
				new CarShader(), carColor, new Texture("./assets/com/specialtopics/racer/car/car2/car2.png"));
	}

}
