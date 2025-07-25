package ch14.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch14.dao.BoardDao;

public class Delete implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String password = request.getParameter("password");
		BoardDao bd = BoardDao.getInstance();
		int result = bd.delete(num, password);

		request.setAttribute("pageNum", pageNum);
		request.setAttribute("result", result);
		return "delete";
	}

}
