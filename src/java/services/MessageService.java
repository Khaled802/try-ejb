/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import boundary.MessageFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author kzaki
 */
@Stateless
public class MessageService {

	@EJB
	private MessageFacade messageFacade;
	

	
}
