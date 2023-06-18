package com.kh.board.challenge.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.challenge.model.vo.ChallengeAttachment;
import com.kh.board.challenge.model.vo.ChallengeBoard;
import com.kh.board.challenge.model.vo.ChallengeVoteQuery;
import com.kh.board.challenge.model.vo.ChallengeVoteTitle;
import com.kh.board.offer.model.vo.OfferAttachment;
import com.kh.board.offer.model.vo.OfferBoard;
import com.kh.common.model.vo.PageInfo;
public class ChallengeDao {
	
private Properties prop = new Properties();
	
	public ChallengeDao() {
		String fileName = ChallengeDao.class.getResource("/sql/board/challenge/challenge-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ChallengeBoard> selectChallengeList(Connection conn, PageInfo pi){
		
		ArrayList<ChallengeBoard> clList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectChallengeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ChallengeBoard cB = new ChallengeBoard();
				
				
				cB.setBoardTitle(rset.getString("BOARD_TITLE"));
				cB.setMemberNo(rset.getInt("MEMBER_NO"));
				cB.setCategory(rset.getString("CATEGORY"));
				cB.setNickName(rset.getString("NICKNAME"));
				cB.setCreateDate(rset.getString("CREATE_DATE"));
				cB.setBoardCount(rset.getInt("BOARD_COUNT"));
				cB.setBoardNo(rset.getInt("BOARD_NO"));
				cB.setTitleImg(rset.getString("TITLEIMG"));
				cB.setBoardContent(rset.getString("BOARD_CONTENT"));
				
				clList.add(cB);
			}
			//System.out.println(clList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return clList;
		
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
	
	public int insertChallengeBoard(Connection conn, ChallengeBoard cB) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertChallengeBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cB.getMemberNo());
			pstmt.setString(2, cB.getCategory());
			pstmt.setString(3, cB.getBoardTitle());
			pstmt.setString(4, cB.getBoardContent());
			pstmt.setString(5, cB.getVoteYN());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int insertChallengeAttachment(Connection conn, ArrayList<ChallengeAttachment> clList){
		
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertChallengeAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(ChallengeAttachment cA : clList) {
				
				pstmt.setInt(1, cA.getFileLevel());
				pstmt.setString(2, cA.getOriginName());
				pstmt.setString(3, cA.getChangeName());
				pstmt.setString(4, cA.getFilePath());
				
				result *= pstmt.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("파일첨부 결과 : " + result );
		return result;
		
	}
	
	public int insertChallengeVoteTitle(Connection conn, ChallengeVoteTitle cvt) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertChallengeVoteTitle");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cvt.getVoteTitle());
			pstmt.setString(2, cvt.getVoteDupli());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		
		return result;
		
	}
	
	public int insertChallengeVoteQuery(Connection conn, ArrayList<ChallengeVoteQuery> queryList) {
		
		
		int result = 1;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertChallengeVoteQuery");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(ChallengeVoteQuery cvq : queryList) {
				
				pstmt.setString(1, cvq.getVoteType());
				pstmt.setString(2, cvq.getQuestion());
				
				result *= pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
	}
	
	public ChallengeBoard ChallengeDetailView(Connection conn, int boardNo) {
		
		ChallengeBoard cB = new ChallengeBoard();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("ChallengeBoardDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				cB.setBoardNo(rset.getInt("BOARD_NO"));
				cB.setMemberNo(rset.getInt("MEMBER_NO"));
				cB.setBoardTitle(rset.getString("BOARD_TITLE"));
				cB.setCategory(rset.getString("CATEGORY"));
				cB.setBoardContent(rset.getString("BOARD_CONTENT"));
				cB.setNickName(rset.getString("NICKNAME"));
				cB.setCreateDate(rset.getString("CREATE_DATE"));
				cB.setBoardCount(rset.getInt("BOARD_COUNT"));
				cB.setBoardReportNo(rset.getInt("BOARD_REPORT_NO"));
				cB.setVoteYN(rset.getString("VOTE_YN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			close(rset);
		}
		return cB;
		
	}
	
	public ArrayList<ChallengeAttachment> ChallengeAttachmentDetailView(Connection conn, int boardNo){
		
		ArrayList<ChallengeAttachment> clList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("ChallengeAttachmentDetailView");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ChallengeAttachment cA = new ChallengeAttachment();
				
				cA.setFileLevel(rset.getInt("FILE_LEVEL"));
				cA.setOriginName(rset.getString("ORIGIN_NAME"));
				cA.setChangeName(rset.getString("CHANGE_NAME"));
				cA.setFilePath(rset.getString("FILE_PATH"));
				cA.setFileNo(rset.getInt("FILE_NO"));
				cA.setBoardNo(rset.getInt("BOARD_NO"));
				
				clList.add(cA);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return clList;
		
	}
	
	public int ChallengeIncreaseCount(Connection conn, int boardNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("ChallengeIncreaseCount");
		
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
	
	public ChallengeVoteTitle ChallengeVoteTitleDetatilView(Connection conn, int boardNo) {
		
		ChallengeVoteTitle cvt = new ChallengeVoteTitle();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("ChallengeVoteTitleDetatilView");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				cvt.setBoardNo(rset.getInt("BOARD_NO"));
				cvt.setVoteNo(rset.getInt("VOTE_NO"));
				cvt.setVoteTitle(rset.getString("VOTE_TITLE"));
				cvt.setVoteDupli(rset.getString("VOTE_DUPLI"));	
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return cvt;
		
	}
	
	public ArrayList<ChallengeVoteQuery> ChallengeVoteQueryDetailView(Connection conn, int voteNo){
		
		ArrayList<ChallengeVoteQuery> queryList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("ChallengeVoteQueryDetailView");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, voteNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ChallengeVoteQuery cvq = new ChallengeVoteQuery();
				cvq.setVoteNo(rset.getInt("VOTE_NO"));
				cvq.setVoteType(rset.getString("VOTE_TYPE"));
				cvq.setQuestion(rset.getString("QUESTION"));
				cvq.setVoteCount(rset.getInt("VOTE_COUNT"));
				
				queryList.add(cvq);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 
		
		return queryList;
		
	}
	
	
	public int increaseChallengeVote(Connection conn, int voteNo, String voteType) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseChallengeVote");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, voteNo);
			pstmt.setString(2, voteType);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int enrollChallengeVote(Connection conn, int memberNo, int voteNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("enrollChallengeVote");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, voteNo);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int dupliIncreaseVote(Connection conn, int voteNo, ArrayList<ChallengeVoteQuery> queryList) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("dupliIncreaseVote");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(int i = 0; i < queryList.size(); i++) {
				
				pstmt.setInt(1, voteNo);
				pstmt.setString(2, queryList.get(i).getVoteType());
				
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int updateChallengeBoard(Connection conn, ChallengeBoard cB) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateChallengeBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cB.getBoardTitle());
			pstmt.setString(2, cB.getBoardContent());
			pstmt.setString(3, cB.getCategory());
			pstmt.setInt(4, cB.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int updateChallengeAttachment(Connection conn, ArrayList<ChallengeAttachment> clList) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("updateChallengeBoardAttachment");
		
		try {
			
			for(ChallengeAttachment cA : clList) {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, cA.getOriginName());
				pstmt.setString(2, cA.getChangeName());
				pstmt.setString(3, cA.getFilePath());
				pstmt.setInt(4, cA.getFileLevel());
				pstmt.setInt(5, cA.getFileNo());
				pstmt.setInt(6, cA.getBoardNo());
				
				result = pstmt.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int newInsertChallengeAttachment(Connection conn, ArrayList<ChallengeAttachment> clList) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("newInsertChallengeAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(int i = 0; i < clList.size(); i++) {
				
				pstmt.setInt(1, clList.get(i).getBoardNo());
				pstmt.setInt(2, clList.get(i).getFileLevel());
				pstmt.setString(3, clList.get(i).getOriginName());
				pstmt.setString(4, clList.get(i).getChangeName());
				pstmt.setString(5, clList.get(i).getFilePath());
				
			}
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteChallengeBoard(Connection conn, int boardNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteChallengeBoard");
		
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
