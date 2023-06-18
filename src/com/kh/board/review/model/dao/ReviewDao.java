package com.kh.board.review.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.offer.model.vo.OfferAttachment;
import com.kh.board.offer.model.vo.OfferBoard;
import com.kh.board.review.model.vo.Review;
import com.kh.common.model.vo.BoardAttachment;
import com.kh.common.model.vo.PageInfo;


public class ReviewDao {
	
private Properties prop = new Properties();
	
	public ReviewDao() {
		String fileName = ReviewDao.class.getResource("/sql/board/review/review-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}


}
	
public int selectListCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
		
		
	}

public ArrayList<Review> selectReviewList(Connection conn, PageInfo pi){
	
	ArrayList<Review> list = new ArrayList();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectReviewList");
	//System.out.println(sql);
	try {
		pstmt = conn.prepareStatement(sql);
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() -1;
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		
		rset = pstmt.executeQuery();
		
		
		
		while(rset.next()) {
			Review oB = new Review();
			
			
			oB.setBoardTitle(rset.getString("BOARD_TITLE"));
			oB.setCategory(rset.getString("CATEGORY"));
			oB.setNickName(rset.getString("NICKNAME"));
			oB.setMemberNo(rset.getInt("MEMBER_NO"));
			oB.setNickName(rset.getString("NICKNAME"));
			oB.setCreateDate(rset.getString("CREATE_DATE"));
			oB.setClosingDate(rset.getString("CLOSING_DATE"));
			oB.setBoardCount(rset.getInt("BOARD_COUNT"));
			oB.setBoardNo(rset.getInt("BOARD_NO"));
			
			list.add(oB);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	
	return list;
	
	
	
}













public int insertReviewBoard(Connection conn, Review oB) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("insertReviewBoard");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, oB.getMemberNo());
		pstmt.setString(2, oB.getCategory());
		pstmt.setString(3, oB.getBoardTitle());
		pstmt.setString(4, oB.getBoardContent());
		pstmt.setString(5, oB.getClosingDate());
		//System.out.println(oB.getClosingDate());
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	
	return result;
	
}

public int insertReviewAttachment(Connection conn, ArrayList<BoardAttachment> oAList) {
	
	int result = 1;
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("insertReviewAttachment");
	
	try {
		for(BoardAttachment oA : oAList) {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, oA.getFileLevel());
			pstmt.setString(2, oA.getOriginName());
			pstmt.setString(3, oA.getChangeName());
			pstmt.setString(4, oA.getFilePath());
			
			result *= pstmt.executeUpdate();
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	
	return result;
}

public Review reviewDetailView(Connection conn, int boardNo) {
	
	Review oB = new Review();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("reviewBoardDetail");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, boardNo);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			oB.setBoardNo(rset.getInt("BOARD_NO"));
			oB.setBoardTitle(rset.getString("BOARD_TITLE"));
			oB.setCategory(rset.getString("CATEGORY"));
			oB.setBoardContent(rset.getString("BOARD_CONTENT"));
			oB.setNickName(rset.getString("NICKNAME"));
			oB.setMemberNo(rset.getInt("MEMBER_NO"));
			oB.setEmail(rset.getString("EMAIL"));
			oB.setCreateDate(rset.getString("CREATE_DATE"));
			oB.setBoardCount(rset.getInt("BOARD_COUNT"));
			
			oB.setBoardReportNo(rset.getInt("BOARD_REPORT_NO"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		
		close(pstmt);
		close(rset);
	}
	return oB;
	
	
}

public int reviewIncreaseCount(Connection conn, int boardNo) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("reviewIncreaseCount");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, boardNo);
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	
	return result;
}

public ArrayList<BoardAttachment> reviewAttachmentDetailView(Connection conn, int boardNo){
	
	ArrayList<BoardAttachment> oAList = new ArrayList();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("reviewAttachmentDetailView");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, boardNo);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			BoardAttachment oA = new BoardAttachment();
			
			oA.setFileLevel(rset.getInt("FILE_LEVEL"));
			oA.setOriginName(rset.getString("ORIGIN_NAME"));
			oA.setChangeName(rset.getString("CHANGE_NAME"));
			oA.setFilePath(rset.getString("FILE_PATH"));
			oA.setFileNo(rset.getInt("FILE_NO"));
			oA.setBoardNo(rset.getInt("BOARD_NO"));
			
			oAList.add(oA);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return oAList;
	
}

public int updateReviewBoard(Connection conn, Review oB) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("updateReviewBoard");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, oB.getBoardTitle());
		pstmt.setString(2, oB.getBoardContent());
		pstmt.setString(3, oB.getCategory());
		pstmt.setString(4, oB.getClosingDate());
		pstmt.setInt(5, oB.getBoardNo());
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	
	return result;
	
}

public int updateReviewAttachment(Connection conn, ArrayList<BoardAttachment> oAList) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	
	String sql = prop.getProperty("updateReviewBoardAttachment");
	
	try {
		
		for(BoardAttachment oA : oAList) {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, oA.getOriginName());
			pstmt.setString(2, oA.getChangeName());
			pstmt.setString(3, oA.getFilePath());
			pstmt.setInt(4, oA.getFileLevel());
			pstmt.setInt(5, oA.getFileNo());
			pstmt.setInt(6, oA.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	
	
	
	return result;
	
}

public int newInsertReviewAttachment(Connection conn, ArrayList<BoardAttachment> oAList) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("newInsertReviewAttachment");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		for(int i = 0; i < oAList.size(); i++) {
			
			pstmt.setInt(1, oAList.get(i).getBoardNo());
			pstmt.setInt(2, oAList.get(i).getFileLevel());
			pstmt.setString(3, oAList.get(i).getOriginName());
			pstmt.setString(4, oAList.get(i).getChangeName());
			pstmt.setString(5, oAList.get(i).getFilePath());
			
		}
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	
	return result;
	
}

public int deleteReviewBoard(Connection conn, int boardNo) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("deleteReviewBoard");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, boardNo);
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	
	return result;
	
}






}
