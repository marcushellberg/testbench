package com.vaadin.training.testbench;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Main UI class
 */
@Theme("testbenchdemotheme")
@SuppressWarnings("serial")
public class TBDemoUI extends UI {

	private VerticalLayout postsLayout;
	private VerticalLayout wrapper;

	@Override
	protected void init(VaadinRequest request) {
		createBaseLayouts();
		addHeader();
		addContentArea();
	}

	private void createBaseLayouts() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);

		wrapper = new VerticalLayout();
		wrapper.setWidth("400px");
		wrapper.setSpacing(true);
		layout.addComponent(wrapper);
		layout.setComponentAlignment(wrapper, Alignment.TOP_CENTER);
	}

	private void addHeader() {
		HorizontalLayout headerLayout = new HorizontalLayout();
		headerLayout.setSpacing(true);

		headerLayout.setWidth("100%");
		final TextField statusField = new TextField();
		statusField.focus();
		statusField.setWidth("100%");
		Button postButton = new Button("Post status", new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				addPost(statusField.getValue());
				statusField.setValue("");
				statusField.focus();
			}

		});
		headerLayout.addComponents(statusField, postButton);
		headerLayout.setExpandRatio(statusField, 1.0f);
		wrapper.addComponent(headerLayout);
	}

	private void addContentArea() {
		postsLayout = new VerticalLayout();
		postsLayout.setSpacing(true);
		wrapper.addComponent(postsLayout);
	}

	private void addPost(String content) {
		PostLayout postLayout = new PostLayout(content);
		postsLayout.addComponent(postLayout);
		postsLayout.setComponentAlignment(postLayout, Alignment.MIDDLE_CENTER);
	}

	public static class PostLayout extends CssLayout {

		public PostLayout(String content) {
			addStyleName("post");
			addComponent(new Label(content));
			setWidth("100%");
		}

	}
}