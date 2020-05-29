#version 330 core 
 
layout(location = 0) out vec4 color; 

in vec2 v_texCoor;
in vec4 v_normal;
in vec4 v_lightDir;

uniform vec4 u_carColor;
uniform sampler2D u_Texture;

void main(){
	vec4 texColor = texture(u_Texture, v_texCoor);
	float sunlight = max(0.2, dot(normalize(v_normal), normalize(v_lightDir)));
	
	color = u_carColor;
	
	if (texColor.x > 0.9 && texColor.y > 0.9 && texColor.z > 0.9) {
		color = u_carColor * sunlight + vec4(0, 0, 0, 1);
	} else {
		color = texColor * sunlight + vec4(0, 0, 0, 1);
	}
}
