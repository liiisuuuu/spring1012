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

@WebServlet("*.ict") //Ȯ����
public class ControllServlet extends HttpServlet { // ���
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	// �����ǰ� �ƴ϶� �������̵� x
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// pro.ict?cmd=fboard
		String cmd = request.getParameter("cmd");
		Action action = null;
		
		if (cmd != null) { // ��û�� ȭ���� �ִٸ�
			ActionFactory factory = ActionFactory.getFactory(); // Factory ��ü �ѹ��� ���� : �̱��� �Ѱ� �ҷ���
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
			out.print("<h2>��û�Ͻ� �������� ���� ���� �ʽ��ϴ�. </h2>");
			out.close();
		}
	}
}
