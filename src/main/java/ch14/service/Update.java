package ch14.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch14.dao.Board;
import ch14.dao.BoardDao;

public class Update implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		Board board = new Board();
		board.setNum(num);
		board.setSubject(subject);
		board.setPassword(password);
		board.setContent(content);

		BoardDao bd = BoardDao.getInstance();
		int result  = bd.update(board);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("result", result);
		
		return "update";
	}

}
