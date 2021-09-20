package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns={"/bag"})
public class BagServlet extends HttpServlet{
	
	Bag myBag = new Bag();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		res.setContentType("text/HTML");
		PrintWriter out = res.getWriter();
		out.println("<form method=\"POST\" action=\"bag\">");
		out.println("<input type=\"text\" name=\"ref\" value=\"Reference\">");
		out.println("<input type=\"text\" name=\"qty\" value=\"Quantite\">");
		out.println("<input type=\"submit\" value=\"envoyer\">");
		out.println("</form>");
	}

	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		res.setContentType("text/HTML");
		PrintWriter out = res.getWriter();
		String ref = req.getParameter("ref");
		String qty = req.getParameter("qty");
		if((ref != null) and (qty != null)){
			out.println(ref);
			out.println(qty);
		}
	}
	
	
	

}
