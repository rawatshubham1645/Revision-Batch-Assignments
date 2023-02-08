package com.masai.myApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class fistClass implements Servlet{

	@Override
	public void destroy() {
		System.out.println("Destroy method Executed");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("InIt Method Executed");
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Service Method Executed");
		
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("Welcome <b>User</b>");
		out.print("<br>"+new Date());
		out.close();
		
	}

}
