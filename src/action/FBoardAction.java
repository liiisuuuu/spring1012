package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

public class FBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = "fboard/fboardList";
		boolean method = false; // forward;
		request.setAttribute("msg", "ListPage!");
		return new ActionForward(url, method);
	}
}