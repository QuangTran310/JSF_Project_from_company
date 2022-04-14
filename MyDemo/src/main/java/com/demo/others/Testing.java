package com.demo.others;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

@Named(value = "testingUIBean")
@SessionScoped
public class Testing implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1911453776031980489L;

	private String message = "Click button below to check whether multiple ajax event can perform in a button!";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void canFirstEventPerformed(AjaxBehaviorEvent event) {
		System.out.println("First event can be performed.");
	}

	public void canSecondEventPerformed(AjaxBehaviorEvent event) {
		System.out.println("Second event can be performed.");
	}

}
