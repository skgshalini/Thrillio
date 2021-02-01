package com.semanticsquare.thrillio.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;


@WebServlet(urlPatterns={"/bookmark","/bookmark/save","/bookmark/mybooks"})
public class BookmarkController extends HttpServlet {
  /* public static BookmarkController instance=new BookmarkController();
   private BookmarkController() {}
   public static  BookmarkController getInstance() {
	   return instance;
   }*/
	public BookmarkController(){
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =null;
		if(request.getSession().getAttribute("userId")!=null) {
			long userId=(long)request.getSession().getAttribute("userId");
			if(request.getServletPath().contains("save")) {
				
				dispatcher=request.getRequestDispatcher("/mybooks.jsp");
				String bid=request.getParameter("bid");
			User user=	UserManager.getInstance().getUser(userId);
		Bookmark bookmark=	BookmarkManager.getInstance().getBook(Long.parseLong(bid));
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
		Collection<Bookmark> list=BookmarkManager.getInstance().getBooks(true,userId);
		request.setAttribute("books", list);
			}else if(request.getServletPath().contains("mybooks")) {
				dispatcher=request.getRequestDispatcher("/mybooks.jsp");
				Collection<Bookmark> list=BookmarkManager.getInstance().getBooks(true,userId);
				request.setAttribute("books", list);
				
			}
			else {dispatcher=request.getRequestDispatcher("/browse.jsp");
			
			Collection<Bookmark> list=BookmarkManager.getInstance().getBooks(false,userId);
				request.setAttribute("books", list);
				//request.getRequestDispatcher("/browse.jsp").forward(request, response);
			}
		}
		else {
			dispatcher=request.getRequestDispatcher("/login.jsp");
		}
		
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
/*public void saveUserBookmark(User user, Bookmark bookmark) {
	BookmarkManager.getInstance().saveUserBookmark(user,  bookmark);
	
}
public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
	BookmarkManager.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus, bookmark);
	
}
public void share(User user, Bookmark bookmark) {
	// TODO Auto-generated method stub
	BookmarkManager.getInstance().share(user, bookmark);
	
}
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>"+
		"<meta charset=\"ISO-8859-1\">"+
		"<title>Books</title>"+
		"</head>"+
		"<body style=\"font-family:Arial;font-size:20px;\">"+
		"<div style=\"height:65px;align: center;background: #DB5227;font-family: Arial;color: white;\">"+
			"<br><b>"+
			"<a href=\"\" style=\"font-family:garamond;font-size:34px;margin:0 0 0 10px;color:white;text-decoration: none;\">Books<i>Aloha!</i></a></b>"+            	    	
		"</div>"+
		"<br><br>"+
		"<table>"+
		  "<tr>"+
		    "<td>"+
		     "<img src=\"http://photo.goodreads.com/books/1170846378m/73968.jpg\">"+
		    "</td>"+
		    
		    "<td style=\"color:gray;\">"+
		    " By <span style=\"color: #B13100;\">Erich Segal</span>"+
		     "<br><br>"+
		     "Rating: <span style=\"color: #B13100;\">3.44</span>"+
		    "</td>"+
		  "</tr>"+
		  "<tr>"+
		     "<td>&nbsp;</td>"+
		  "</tr>"+
		  "<tr>"+
		    "<td>"+
		    " <img src=\"http://ecx.images-amazon.com/images/I/21WBe6pNO5L._SX106_.jpg\" />"+
		    "</td>"+
		    "<td style=\"color:gray;\">"+
		    " By <span style=\"color:#B13100;\">Lillian Eichler Watson</span>"+
		    " <br><br>"+
		    "Rating: <span style=\"color: #B13100;\">5.0</span>"+
		    "</td>"+
		  "</tr>"+
		  
		   
		"</table>"+
		"</body>");
		
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/



