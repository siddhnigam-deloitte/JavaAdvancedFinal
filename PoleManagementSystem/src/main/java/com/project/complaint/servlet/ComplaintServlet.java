package com.project.complaint.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.entity.registration.RegisterEntity;
import com.project.repository.registration.RegisterReposDAO;

/**
 * Servlet implementation class ComplaintServlet
 */
@WebServlet("/ComplaintServlet")
public class ComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ComplaintEntity complaintentity=new ComplaintEntity();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ComplaintServlet() {
        
    	super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

//		out.print(request.getAttribute("message"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		PrintWriter out=response.getWriter();
//		response.setContentType("text/html");
//		out.print(request.getAttribute("message"));
		
		int cid=Integer.parseInt(request.getParameter("CID"));
		int pid=Integer.parseInt(request.getParameter("PID"));
		String comment = request.getParameter("comment");
		String username=request.getParameter("uname");
		String status = "Pending";		
		
		complaintentity.setCid(cid);
		complaintentity.setPid(pid);
		complaintentity.setComment(comment);
		complaintentity.setUsername(username);
		complaintentity.setStatus(status);
		ComplaintReposDao CDao = new ComplaintReposDao();
		String result = CDao.insert(complaintentity);
		
		response.getWriter().print(result);
	}

}
