#version 330 core 
 
layout(location = 0) in vec4 position; 

uniform mat4 u_MV;
uniform mat4 u_P;

void main(){
 	gl_Position = u_MV * u_P * position; 
}
