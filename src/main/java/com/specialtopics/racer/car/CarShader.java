package com.specialtopics.racer.car;

import com.oroarmor.core.game.light.Sunlight;
import com.oroarmor.core.opengl.Shader;
import com.oroarmor.core.opengl.Texture;
import com.oroarmor.util.ResourceLoader;

public class CarShader extends Shader {

	public CarShader() {
		super(//
				ResourceLoader.loadFile(Class.class.getResourceAsStream("/com/specialtopics/racer/car/car_vertex.vs")),
				ResourceLoader
						.loadFile(Class.class.getResourceAsStream("/com/specialtopics/racer/car/car_fragment.fs")));
		compile();
	}

	public void setSun(final Sunlight sun) {
		setUniform3f("u_lightDir", sun.getDirection());
	}

	public void setMainTexture(final Texture texture) {
		texture.bind(1);
		bind();
		setUniform1i("u_Texture", 1);
	}

}
