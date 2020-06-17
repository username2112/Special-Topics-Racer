package com.specialtopics.racer.gui;

import java.awt.event.KeyEvent;

import org.joml.Vector4f;

import com.oroarmor.core.game.gui.GUICallback;
import com.oroarmor.core.game.gui.animation.ColorTransition;
import com.oroarmor.core.game.gui.animation.Easing;
import com.oroarmor.core.game.gui.animation.ScaleAnimation;
import com.oroarmor.core.game.gui.group.GUIGroup;
import com.oroarmor.core.game.gui.object.box.GUIColorBox;
import com.oroarmor.core.game.gui.object.box.TexturedGUIBox;
import com.oroarmor.core.glfw.event.mouse.button.MouseButton;
import com.oroarmor.core.opengl.Renderer;
import com.oroarmor.core.opengl.Texture;
import com.specialtopics.racer.Racer;
import com.specialtopics.racer.graphics.RacerDisplay;

public class RacerGUI extends GUIGroup {

	private static RacerGUI instance;
	private boolean paused = false;
	private int pausedn = 1;

	public RacerGUI(RacerDisplay display) {
		super(0, 0);
		instance = this;
		initalize(display);
	}

	public void initalize(RacerDisplay display) {

		// Create a renderer

		// Does Something idk Eli added it so we probably need it

		// ----menuBoxs content----\\

		// Title info
		int titleWidth = 749, titleHeight = 216;
		int titleX = (display.getWidth() - titleWidth) / 2, titleY = 50;

		final TexturedGUIBox title = new TexturedGUIBox(titleX, titleY, titleWidth, titleHeight,
				new Texture("./assets/com/specialtopics/racer/menu/Capture.PNG"));

		// Box info
		float buttonWidth = 250, buttonHeight = 100;
		float buttonX = (display.getWidth() - buttonWidth) / 2, buttonY = (display.getHeight() + buttonHeight) / 2;
		Vector4f buttonColor = new Vector4f(0.7f, 0.7f, 0.7f, 10);

		final GUIColorBox mainBox = new GUIColorBox(buttonX, buttonY, buttonWidth, buttonHeight, buttonColor);

		// Make button visible
		mainBox.setActive(true);
		mainBox.setCallback(new GUICallback() {
			@Override
			// starts hover animation
			public void onHover() {
				mainBox.setCurrentColorAsOriginal();
				mainBox.triggerAnimation(new ColorTransition(200L, Easing.EaseInOutSin,
						new Vector4f(buttonColor.x + 0.1f, buttonColor.y + 0.1f, buttonColor.z + 0.1f, buttonColor.w)));
				mainBox.triggerAnimation(new ScaleAnimation<GUIColorBox>(200L, Easing.EaseInOutSin, 0.025f));
			}

			@Override
			// ends hover animation
			public void onHoverStop() {
				mainBox.setCurrentColorAsOriginal();
				mainBox.triggerAnimation(new ColorTransition(200L, Easing.EaseInOutSin, buttonColor));
				mainBox.triggerAnimation(new ScaleAnimation<GUIColorBox>(200L, Easing.EaseInOutSin, 0f));
			}

			@Override
			// after release of mouse (so do thing)
			public void onRelease(final MouseButton button, final boolean inBounds) {
				if (!inBounds) {
					return;
				}
				RacerGUI.getInstance().makeVisable(false);
				Racer.getInfo().startGame();
			}
		});

		// adds title and button to GUI group
		addChildren(mainBox, title);

		makeVisable(true);
	}

	public static RacerGUI getInstance() {
		return instance;
	}

	@Override
	public void render(Renderer renderer) {
		children.forEach(c -> c.render(renderer));
	}
	

}
