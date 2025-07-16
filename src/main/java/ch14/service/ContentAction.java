package ch14.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch14.dao.Board;
import ch14.dao.BoardDao;

public class ContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		BoardDao bd = BoardDao.getInstance();
		bd.readCountUpdate(num);       // 조회하면 조회수 1증가
		Board board = bd.select(num);  // num해당하는 게시글 조회
		request.setAttribute("board", board);
		request.setAttribute("pageNum", pageNum);

		return "content";
	}

}
