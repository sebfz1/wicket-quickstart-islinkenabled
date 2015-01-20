package com.mycompany;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class AjaxLinkPage extends WebPage
{
	private static final long serialVersionUID = 1L;

	public AjaxLinkPage(final PageParameters parameters)
	{
		super(parameters);
		
		final FeedbackPanel feedback = new FeedbackPanel("feedback");
		this.add(feedback.setOutputMarkupId(true));

		// Form //
		final Form<Void> form = new Form<Void>("form");
		this.add(form.setEnabled(false));
		
		// Links //
		form.add(new AjaxLink<Void>("link") {

			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isLinkEnabled() {
				return true;
			}

			@Override
			public void onClick(AjaxRequestTarget target) {
				info("link clicked");
				target.add(feedback);
			}
		});
		
		form.add(new BookmarkablePageLink<Void>("back", HomePage.class) {

			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isLinkEnabled() {
				return true;
			}
		});

		// version //
		this.add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
	}
}
