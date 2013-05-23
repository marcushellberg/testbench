package com.vaadin.training.testbench;

import com.vaadin.ui.themes.ChameleonTheme;

public class TrainingTheme extends ChameleonTheme {

	// General style names go here
	public static final String ERROR_LABEL = "error-label";

	// View specific style names are scoped for clarity

	public static class LoginView {
		public static final String STYLENAME = "login-view";
		public static final String LOGIN_BOX = "login-box";
	}

	public static class PostsView {
		public static final String STYLENAME = "posts-view";
		public static final String WRAPPER = "wrapper";
		public static final String HEADER = "header";
		public static final String POSTS_LAYOUT = "posts-layout";
		public static final String POST = "post";
	}

}
