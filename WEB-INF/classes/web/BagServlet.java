package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns={"/bag"})
public class BagServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {

		HttpSession session = req.getSession(true);
		Bag myBag = (Bag)session.getAttribute("bag");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		if (myBag != null) myBag.print(out);
		out.println("<form method=\"POST\" action=\"bag\">");
		out.println("<input type=\"text\" name=\"ref\" value=\"Reference\">");
		out.println("<input type=\"text\" name=\"qty\" value=\"Quantite\">");
		out.println("<input type=\"submit\" value=\"envoyer\">");
		out.println("</form>");
	}

	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		if (session.getAttribute("bag") == null){
			session.setAttribute("bag",new Bag());
		}

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String ref = req.getParameter("ref");
		String qty = req.getParameter("qty");

		// VERIFICATION DONNEES ENTREES PAR L'UTILISATEUR
		if((ref == "") || (qty == "") || (ref == null) || (qty == null)){
			//res.setStatus(400);
			res.sendError(400,"At least one paramater is empty !");
		}
		else{if(!(qty.matches("[0-9]+"))){
			res.sendError(400,"Quantity MUST be a number !");
		}}


		Bag myBag = (Bag)session.getAttribute("bag");
		myBag.setItem(ref,Integer.parseInt(qty));
		session.setAttribute("bag",myBag);
		res.sendRedirect(req.getContextPath()+"/bag.jsp");

	}
	
	
	

}
