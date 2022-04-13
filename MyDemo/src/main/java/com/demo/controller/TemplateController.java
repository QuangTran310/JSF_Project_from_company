package com.demo.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "templateControllerUIBean")
@SessionScoped
public class TemplateController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1718630665473723417L;

	private String templateCode = "home";

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		System.out.println("On processing to change template code ...");
		this.templateCode = templateCode;
		System.out.println("Template code has been changed to '" + this.templateCode + "'");
	}

}
