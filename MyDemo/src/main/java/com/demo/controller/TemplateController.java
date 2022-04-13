package com.demo.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "templateControllerUIBean")
@ConversationScoped
public class TemplateController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1718630665473723417L;

	@Inject
	Conversation conversation;

	private String templateCode = "home";

	@PostConstruct
	public void initBean() {
		System.out.println("Start initiate bean 'templateControllerUIBean'.");
	}

	@PreDestroy
	public void destroyBean() {
		System.out.println("Destroy bean 'templateControllerUIBean'.");
	}

	public void initConversation() {
		if (!FacesContext.getCurrentInstance().isPostback() && conversation.isTransient()) {
			conversation.begin();
		}
		System.out.println("Conversation has been beginned.");
	}

	public void endConversation() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
		System.out.println("Conversation has been finished.");
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

}
