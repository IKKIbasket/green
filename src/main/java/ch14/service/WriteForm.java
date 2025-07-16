package ch14.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch14.dao.Board;
import ch14.dao.BoardDao;

public class WriteForm implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		int num = 0, ref = 0, re_level = 0, re_step = 0;
		String pageNum = request.getParameter("pageNum");
		num = Integer.parseInt(request.getParameter("num"));
		if(num != 0){ // 답변.  num 0 은 처음 쓰는 글
			BoardDao bd = BoardDao.getInstance();
			Board board = bd.select(num);
			ref = board.getRef();
			re_level = board.getRe_level();
			re_step = board.getRe_step();
		}
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("ref", ref);
		request.setAttribute("re_level", re_level);
		request.setAttribute("re_step", re_step);
		return "writeForm";
	}

}
