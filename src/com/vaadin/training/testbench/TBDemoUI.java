package com.vaadin.training.testbench;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * Main UI class
 */
@Theme("testbenchdemotheme")
@SuppressWarnings("serial")
public class TBDemoUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		setContent(new LoginView(this));
	}

	public void loginSuccessful() {
		Navigator navigator = new Navigator(this, this);
		navigator.addView(PostsView.NAME, PostsView.class);

		navigator.navigateTo(PostsView.NAME);
	}

}