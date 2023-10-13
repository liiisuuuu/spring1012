package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

@WebServlet("*.ict") //확장자
public class ControllServlet extends HttpServlet { // 상속
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	// 재정의가 아니라서 오버라이드 x
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// pro.ict?cmd=fboard
		String cmd = request.getParameter("cmd");
		Action action = null;
		
		if (cmd != null) { // 요청된 화면이 있다면
			ActionFactory factory = ActionFactory.getFactory(); // Factory 객체 한번만 생성 : 싱글톤 한거 불러옴
			action = factory.getAction(cmd);
			ActionForward af = action.execute(request, response);
			
			if (af.isMethod()) { // true : redirect
				response.sendRedirect(af.getUrl());
			} else {
				String path = "/WEB-INF/views";
				RequestDispatcher rd = request.getRequestDispatcher(path + "/" + af.getUrl() + ".jsp");
				rd.forward(request, response);
			}
		} else {
			response.setContentType("type/html);charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.print("<h2>요청하신 페이지는 존재 하지 않습니다. </h2>");
			out.close();
		}
	}
}
