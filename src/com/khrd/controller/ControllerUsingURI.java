package com.khrd.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerUsingURI extends HttpServlet {

	private HashMap<String, CommandHandler> CommandHandlerMap = new HashMap<>();

	public void init() throws ServletException{
		
		String configFile = getInitParameter("configFile");
		
		
		Properties prop = new Properties();
		
		
		String configFilePath = getServletContext().getRealPath(configFile);
		
		try (FileReader fis = new FileReader(configFilePath) ){
			
			prop.load(fis);
			
		}catch(Exception e ) {
			
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
			
			String command = (String) keyIter.next();
			String handlerClassName = prop.getProperty(command);
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				CommandHandler handler = (CommandHandler) handlerClass.newInstance();
				CommandHandlerMap.put(command,handler);
				
				
			}catch( Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
	
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		process(req, resp);
	}
	
	
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String command = request.getRequestURI();
		if (command.indexOf(request.getContextPath()) == 0) {

			command = command.substring(request.getContextPath().length());
		

		}
		
		CommandHandler handler = CommandHandlerMap.get(command);
		
		
		if(handler == null) {
			handler = new NullHandler();
			
		}
		
		String viewPage = null;
		
		
		try {
			viewPage = handler.process(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
			
		}
		
		if(viewPage != null) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
