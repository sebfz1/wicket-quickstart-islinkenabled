package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		this.add(new FeedbackPanel("feedback"));

		// Form //
		final Form<Void> form = new Form<Void>("form");
		this.add(form.setEnabled(false));

		// Links //
		form.add(new Link<Void>("link") {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isLinkEnabled() {
				return true;
			}

			@Override
			public void onClick() {
				info("link clicked");
			}
		});

		form.add(new BookmarkablePageLink<Void>("link1", AjaxLinkPage.class) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isLinkEnabled() {
				return true;
			}
		});

		form.add(new BookmarkablePageLink<Void>("link2", AjaxSubmitLinkPage.class) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isLinkEnabled() {
				return true;
			}
		});

		// version //
		this.add(new Label("version", getApplication().getFrameworkSettings()
				.getVersion()));
	}
}
