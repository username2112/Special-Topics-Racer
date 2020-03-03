package com.specialtopics.racer.graphics;

import com.oroarmor.core.glfw.Display;
import com.oroarmor.core.glfw.event.key.Key;
import com.oroarmor.core.glfw.event.key.hold.KeyHoldEvent;
import com.oroarmor.core.glfw.event.key.press.KeyPressEvent;
import com.oroarmor.core.glfw.event.key.release.KeyReleaseEvent;
import com.oroarmor.core.glfw.event.mouse.button.press.MousePressEvent;
import com.oroarmor.core.glfw.event.mouse.button.release.MouseReleaseEvent;
import com.oroarmor.core.glfw.event.mouse.over.enter.MouseEnterEvent;
import com.oroarmor.core.glfw.event.mouse.over.leave.MouseLeaveEvent;
import com.oroarmor.core.glfw.event.mouse.position.MousePositionEvent;
import com.oroarmor.core.glfw.event.mouse.scroll.MouseScrollEvent;
import com.specialtopics.racer.event.gameclose.GameCloseEvent;
import com.specialtopics.racer.event.gameclose.GameCloseEventListener;

public class RacerDisplay extends Display {

	public RacerDisplay() {
		super(1280, 720, "Space Racer");
		this.addToListeners();
	}

	@Override
	public void processKeyPressedEvent(KeyPressEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processKeyHeldEvent(KeyHoldEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processKeyReleasedEvent(KeyReleaseEvent event) {
		if (event.getKey() == Key.ESCAPE) {
			GameCloseEventListener.processAllGameCloseEvent(new GameCloseEvent());
		}
	}

	@Override
	public void processMouseScrolledEvent(MouseScrollEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processMousePressEvent(MousePressEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processMouseReleasedEvent(MouseReleaseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processMousePositionEvent(MousePositionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processMouseLeaveEvent(MouseLeaveEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processMouseEnterEvent(MouseEnterEvent event) {
		// TODO Auto-generated method stub

	}

}
