/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author kzaki
 */
@Named(value = "messageView")
@Dependent
@ManagedBean
public class MessageView {

	@EJB
	private MessageFacade messageFacade;

	private Message message;

	/**
	 * Creates a new instance of MessageView
	 */
	public MessageView() {
		this.message = new Message();
		this.message.setMessage("hi");
	}

	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

	public String postMessage() {
		messageFacade.create(message);
		return "theend";
	}

	public int getMessagesNumber() {
		return messageFacade.count();
	}
	public List<Message> getHiMessages() {
		
		List<Message> messages = messageFacade.searchByName();
		System.out.println(messages);
		return messages;
	}

}
