package com.kh.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberAttach;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 1024 * 1024 * 10;
			
			HttpSession session = request.getSession();
			ServletContext application = session.getServletContext();
			String savePath = application.getRealPath("/resources/member_upfiles/");
			
			MultipartRequest multiRequest =
					new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String memberId = multiRequest.getParameter("userId");
			String memberPwd = multiRequest.getParameter("userPwd");
			String nickname = multiRequest.getParameter("nickname");
			String email = multiRequest.getParameter("email");
			String memberType = multiRequest.getParameter("type");
			
			Member m = new Member();
			m.setMemberId(memberId);
			m.setMemberPwd(memberPwd);
			m.setNickname(nickname);
			m.setEmail(email);
			m.setMemberType(memberType);
			
			
			MemberAttach at = null;
			
			if(multiRequest.getOriginalFileName("upfile") != null) {
				
				at = new MemberAttach();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				at.setFilePath("resources/member_upfiles");
				
			}
			
			int result = new MemberService().insertMember_1(m, at);
			
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "회원가입이 완료 되었습니다! 지금 바로 운동인들과 소통을 시작하세요!");
				response.sendRedirect(request.getContextPath() + "/loginForm.do");
			} else {
				if(at != null) {
					new File(savePath + at.getChangeName()).delete();
				} 
				request.getSession().setAttribute("alertMsg", "회원가입에 실패 했습니다! 다시 시도 해 주세요.");
				response.sendRedirect(request.getContextPath() + "/enrollForm.me");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}