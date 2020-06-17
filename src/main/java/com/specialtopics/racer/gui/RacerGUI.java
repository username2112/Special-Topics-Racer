package com.specialtopics.racer.gui;

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

	public RacerGUI(RacerDisplay display) {
		super(0, 0);
		instance = this;
		initalize(display);
	}

	public void initalize(RacerDisplay display) {

		// ----Menu Content----\\

		// Title info
		int titleWidth = 750, titleHeight = 220;
		int titleX = (display.getWidth() - titleWidth) / 2, titleY = 50;

		final TexturedGUIBox title = new TexturedGUIBox(titleX, titleY, titleWidth, titleHeight,
				new Texture("./assets/com/specialtopics/racer/menu/Capture.PNG"));
		
		//background
		final TexturedGUIBox background = new TexturedGUIBox(0, 0, display.getWidth(), display.getHeight(),
				new Texture("./assets/com/specialtopics/racer/menu/hyNnT0.jpg"));

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
						new Vector4f(1, 1, 1, buttonColor.w)));
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
		
		float cbuttonWidth = 250, cbuttonHeight = 100;
		float cbuttonX = (display.getWidth() - cbuttonWidth) / 2, cbuttonY = ((display.getHeight() + cbuttonHeight) / 2) + buttonHeight + 50;
		Vector4f cbuttonColor = new Vector4f(0.7f, 0.7f, 0.7f, 10);

		final GUIColorBox creditBox = new GUIColorBox(cbuttonX, cbuttonY, cbuttonWidth, cbuttonHeight, cbuttonColor);
		
		//Credits button
		creditBox.setActive(true);
		creditBox.setCallback(new GUICallback() {
			@Override
			// starts hover animation
			public void onHover() {
				creditBox.setCurrentColorAsOriginal();
				creditBox.triggerAnimation(new ColorTransition(200L, Easing.EaseInOutSin,
						new Vector4f(1, 1, 1, cbuttonColor.w)));
				creditBox.triggerAnimation(new ScaleAnimation<GUIColorBox>(200L, Easing.EaseInOutSin, 0.025f));
			}

			@Override
			// ends hover animation
			public void onHoverStop() {
				creditBox.setCurrentColorAsOriginal();
				creditBox.triggerAnimation(new ColorTransition(200L, Easing.EaseInOutSin, cbuttonColor));
				creditBox.triggerAnimation(new ScaleAnimation<GUIColorBox>(200L, Easing.EaseInOutSin, 0f));
			}

			@Override
			// after release of mouse (so do thing)
			public void onRelease(final MouseButton button, final boolean inBounds) {
				if (!inBounds) {
					return;
				}
				
				//RacerGUI.getInstance().makeVisable(false);
				//Racer.getInfo().startGame();
			}
		});
		//button text
		final TexturedGUIBox start = new TexturedGUIBox(buttonX, buttonY, buttonWidth, buttonHeight,
				new Texture("./assets/com/specialtopics/racer/menu/captur.png"));
		final TexturedGUIBox credit = new TexturedGUIBox(cbuttonX, cbuttonY, cbuttonWidth, cbuttonHeight,
				new Texture("./assets/com/specialtopics/racer/menu/captu.png"));
		
		// adds title and button to GUI group
		addChildren(start, mainBox, credit, creditBox, title, background);

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
