package com.specialtopics.racer.gui;

import org.joml.Vector4f;

import com.oroarmor.core.game.gui.GUICallback;
import com.oroarmor.core.game.gui.animation.ColorTransition;
import com.oroarmor.core.game.gui.animation.Easing;
import com.oroarmor.core.game.gui.animation.ScaleAnimation;
import com.oroarmor.core.game.gui.group.GUIGroup;
import com.oroarmor.core.game.gui.object.box.GUIColorBox;
import com.oroarmor.core.game.gui.object.box.TexturedGUIBox;
import com.oroarmor.core.game.gui.shader.GUIShaders;
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

		/*
		 * Note: The reason all the text is in Images instead of text is because the
		 * library was having issues with text opposed to images
		 */

		// Title info
		int titleWidth = 600, titleHeight = 270;
		int titleX = (display.getWidth() - titleWidth) / 2, titleY = 30;

		final TexturedGUIBox title = new TexturedGUIBox(titleX, titleY, titleWidth, titleHeight,
				new Texture("./assets/com/specialtopics/racer/menu/title2.PNG"));

		// background
		final TexturedGUIBox background = new TexturedGUIBox(0, 0, display.getWidth(), display.getHeight(),
				new Texture("./assets/com/specialtopics/racer/menu/background.jpg")) {
			@Override
			public void render(Renderer renderer) {
				boxMesh.render(renderer, GUIShaders.getTextureShader().setZ(-1).setTexture(this.getTexture())
						.setObjectModel(animationMatrix));
			}
		};

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
				mainBox.triggerAnimation(
						new ColorTransition(200L, Easing.EaseInOutSin, new Vector4f(1, 1, 1, buttonColor.w)));
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
		float cbuttonX = (display.getWidth() - cbuttonWidth) / 2,
				cbuttonY = ((display.getHeight() + cbuttonHeight) / 2) + buttonHeight + 50;
		Vector4f cbuttonColor = new Vector4f(0.7f, 0.7f, 0.7f, 10);

		final GUIColorBox creditBox = new GUIColorBox(cbuttonX, cbuttonY, cbuttonWidth, cbuttonHeight, cbuttonColor);

		final TexturedGUIBox creditText = new TexturedGUIBox(buttonX + buttonWidth + 20, buttonY - buttonHeight, 350,
				400, new Texture("./assets/com/specialtopics/racer/menu/creditText.png"));

		GUIGroup creditsGroup = new GUIGroup(0, 0, true) {

			@Override
			public void render(Renderer renderer) {
				if (!isVisable())
					children.forEach(c -> c.render(renderer));
			}

		};

		creditsGroup.addChildren(creditText);

		// Credits button
		creditBox.setActive(true);
		creditBox.setCallback(new GUICallback() {
			@Override
			// starts hover animation
			public void onHover() {
				creditBox.setCurrentColorAsOriginal();
				creditBox.triggerAnimation(
						new ColorTransition(200L, Easing.EaseInOutSin, new Vector4f(1, 1, 1, cbuttonColor.w)));
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
				creditsGroup.makeVisable(creditsGroup.isVisable());
			}
		});

		// button text
		final TexturedGUIBox start = new TexturedGUIBox(buttonX, buttonY, buttonWidth, buttonHeight,
				new Texture("./assets/com/specialtopics/racer/menu/start.png")) {
			@Override
			public void render(Renderer renderer) {
				boxMesh.render(renderer, GUIShaders.getTextureShader().setZ(0).setTexture(this.getTexture())
						.setObjectModel(animationMatrix));
			}
		};
		final TexturedGUIBox credit = new TexturedGUIBox(cbuttonX, cbuttonY, cbuttonWidth, cbuttonHeight,
				new Texture("./assets/com/specialtopics/racer/menu/credits.png"));

		// adds title and button to GUI group
		addChildren(background, start, mainBox, credit, creditBox, title, creditsGroup);

		makeVisable(true);
		creditsGroup.makeVisable(false);
	}

	public static RacerGUI getInstance() {
		return instance;
	}

	@Override
	public void render(Renderer renderer) {
		children.forEach(c -> c.render(renderer));
	}

}
