package com.specialtopics.racer;

import org.joml.Vector4f;

import com.oroarmor.core.game.gui.GUICallback;
import com.oroarmor.core.game.gui.animation.ColorTransition;
import com.oroarmor.core.game.gui.animation.Easing;
import com.oroarmor.core.game.gui.animation.ScaleAnimation;
import com.oroarmor.core.game.gui.group.GUIGroup;
import com.oroarmor.core.game.gui.object.box.GUIBox;
import com.oroarmor.core.game.gui.object.box.GUIColorBox;
import com.oroarmor.core.game.gui.object.box.TexturedGUIBox;
import com.oroarmor.core.game.gui.shader.GUIShaders;
import com.oroarmor.core.glfw.Display;
import com.oroarmor.core.glfw.GLFWUtil;
import com.oroarmor.core.glfw.GLFWUtil.OpenGLProfile;
import com.oroarmor.core.glfw.event.key.Key;
import com.oroarmor.core.glfw.event.key.hold.KeyHoldEvent;
import com.oroarmor.core.glfw.event.key.press.KeyPressEvent;
import com.oroarmor.core.glfw.event.key.release.KeyReleaseEvent;
import com.oroarmor.core.glfw.event.mouse.button.MouseButton;
import com.oroarmor.core.glfw.event.mouse.button.press.MousePressEvent;
import com.oroarmor.core.glfw.event.mouse.button.release.MouseReleaseEvent;
import com.oroarmor.core.glfw.event.mouse.over.enter.MouseEnterEvent;
import com.oroarmor.core.glfw.event.mouse.over.leave.MouseLeaveEvent;
import com.oroarmor.core.glfw.event.mouse.position.MousePositionEvent;
import com.oroarmor.core.glfw.event.mouse.scroll.MouseScrollEvent;
import com.oroarmor.core.opengl.Renderer;
import com.oroarmor.core.opengl.Texture;

public class Menu {
	static GUIGroup menuBoxs;
	
	
	public static Display initMenu() {

		// Create a new window with a onKey function that prints the typed key
		final Display display = new Display(640, 640, "Spacer Menu") {
			
			@Override
			public void processKeyHeldEvent(final KeyHoldEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void processKeyPressedEvent(final KeyPressEvent event) {
				// TODO Auto-generated method stub
			}

			@Override
			public void processKeyReleasedEvent(final KeyReleaseEvent event) {
				if (event.getKey() == Key.ESCAPE) {
					close();
				}
			}

			@Override
			public void processMouseEnterEvent(final MouseEnterEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void processMouseLeaveEvent(final MouseLeaveEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void processMousePositionEvent(final MousePositionEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void processMousePressEvent(final MousePressEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void processMouseReleasedEvent(final MouseReleaseEvent event) {
				// TODO Auto-generated method stub
			}

			@Override
			public void processMouseScrolledEvent(final MouseScrollEvent event) {
				// TODO Auto-generated method stub

			}

		};

		
		//----Establishing Code----\\
		
		//Does something
		display.enableTransparency();
		
		// Set the OpenGL version to 4.5 core
		GLFWUtil.setWindowHints(4, 5, OpenGLProfile.CORE);

		//Create ui
		final GUIGroup ui = new GUIGroup(0, 0) {
		};
		
		// Create a renderer
		final Renderer renderer = new Renderer();
		
		//Does Something idk Eli added it so we probably need it
		display.setClearColor(0, 0, 0, 1);
		
		//Create image box (title)
		menuBoxs = new GUIGroup(0, 0) {
		};
		
		
		//----menuBoxs content----\\
		
		//Title info
		int titleWidth = 749, titleHeight = 216;
		int titleX = (display.getWidth() - titleWidth) / 2, titleY = 50;
		
		final TexturedGUIBox title = new TexturedGUIBox(titleX, titleY, titleWidth, titleHeight, new Texture("./assets/com/specialtopics/racer/menu/Capture.PNG"));
		
		//Box info
		float buttonWidth = 250, buttonHeight = 100;
		float buttonX = (display.getWidth() - buttonWidth) / 2, buttonY = (display.getHeight() + buttonHeight) / 2;
		Vector4f buttonColor = new Vector4f(0.7f, 0.7f, 0.7f, 10);
		
		final GUIColorBox mainBox = new GUIColorBox(buttonX, buttonY, buttonWidth, buttonHeight, buttonColor);
		
		//Make button visible
		mainBox.setActive(true);
		mainBox.setCallback(new GUICallback() {
			@Override
			//starts hover animation
			public void onHover() {
				mainBox.setCurrentColorAsOriginal();
				mainBox.triggerAnimation(
						new ColorTransition(200L, Easing.EaseInOutSin, new Vector4f(buttonColor.x + 0.1f, buttonColor.y + 0.1f, buttonColor.z + 0.1f, buttonColor.w)));
				mainBox.triggerAnimation(new ScaleAnimation<GUIColorBox>(200L, Easing.EaseInOutSin, 0.025f));
			}

			@Override
			//ends hover animation
			public void onHoverStop() {
				mainBox.setCurrentColorAsOriginal();
				mainBox.triggerAnimation(new ColorTransition(200L, Easing.EaseInOutSin, buttonColor));
				mainBox.triggerAnimation(new ScaleAnimation<GUIColorBox>(200L, Easing.EaseInOutSin, 0f));
			}

			@Override
			//after release of mouse (so do thing)
			public void onRelease(final MouseButton button, final boolean inBounds) {
				if (!inBounds) {
					return;
				}
				display.close();
			}
		});

		//adds title and button to GUI group
		menuBoxs.addChildren(mainBox, title);
		
		//honestly IDK
		ui.addChildren(menuBoxs);
		menuBoxs.makeVisable(true);
		
		//rendering stuff
		while (!display.shouldClose()) {
			// Clear the display
			display.clear();

			GUIShaders.updateShaderView(display.getOrthoViewModel());
			ui.renderChildren(renderer);

			display.render();
		}

		// Close the display
		display.close();
		return display;

	}

}
