package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.FboardDAO;
import dto.FboardDTO;

// list
public class FBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = "fboard/fboardList";
		boolean method = false; // forward
		
		// DAO 연결 사용
		List<FboardDTO> list = FboardDAO.getDao().listFboard();
		request.setAttribute("list", list);
		request.setAttribute("msg", "ListPage!");
		
		return new ActionForward(url, method);
	}
}