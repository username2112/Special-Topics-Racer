package com.specialtopics.racer.level;

import com.oroarmor.core.game.light.Sunlight;
import com.oroarmor.core.opengl.Shader;
import com.oroarmor.core.opengl.Texture;
import com.oroarmor.util.ResourceLoader;

public class LevelShader extends Shader {

	public LevelShader() {
		super(//
				ResourceLoader
						.loadFile(Class.class.getResourceAsStream("/com/specialtopics/racer/level/level_vertex.vs")),
				ResourceLoader
						.loadFile(Class.class.getResourceAsStream("/com/specialtopics/racer/level/level_fragment.fs")));
		this.compile();
	}

	public void setSun(Sunlight sun) {
		this.setUniform3f("u_lightDir", sun.getDirection());
	}

	public void setMainTexture(Texture texture) {
		texture.bind(1);
		this.bind();
		this.setUniform1i("u_Texture", 1);
	}
}
