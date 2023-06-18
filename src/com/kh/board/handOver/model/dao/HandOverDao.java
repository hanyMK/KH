package com.kh.board.handOver.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.handOver.model.vo.HandOver;
import com.kh.board.offer.model.vo.OfferAttachment;
import com.kh.board.offer.model.vo.OfferBoard;
import com.kh.common.model.vo.BoardAttachment;
import com.kh.common.model.vo.PageInfo;


public class HandOverDao {
private Properties prop = new Properties();
	
	public HandOverDao() {
		String fileName = HandOverDao.class.getResource("/sql/board/handOver/handOver-mapper.xml").getPath();
		
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
	
	public ArrayList<HandOver> selectHandOverList(Connection conn, PageInfo pi){
			
			ArrayList<HandOver> list = new ArrayList();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectHandOverList");
			//System.out.println(sql);
			try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
				int endRow = startRow + pi.getBoardLimit() -1;
				System.out.println("시작"+startRow +", 끝="+endRow);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rset = pstmt.executeQuery();
				
				
				
				while(rset.next()) {
					HandOver ho = new HandOver();
					
					
					ho.setBoardTitle(rset.getString("BOARD_TITLE"));
					ho.setCategory(rset.getString("CATEGORY"));
					ho.setNickName(rset.getString("NICKNAME"));
					ho.setCreateDate(rset.getString("CREATE_DATE"));
					ho.setBoardCount(rset.getInt("BOARD_COUNT"));
					ho.setBoardNo(rset.getInt("BOARD_NO"));
					
					list.add(ho);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
	
	public int HandOverIncreaseCount(Connection conn, int boardNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("HandOverIncreaseCount");
		
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
	
	public HandOver selectHandOverBoard(Connection conn, int boardNo) {
		HandOver handover = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectHandOverBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				handover = new HandOver();
				handover.setBoardNo(rset.getInt("BOARD_NO"));
				handover.setBoardTitle(rset.getString("BOARD_TITLE"));
				handover.setCategory(rset.getString("CATEGORY"));
				handover.setBoardContent(rset.getString("BOARD_CONTENT"));
				handover.setNickName(rset.getString("NICKNAME"));
				handover.setMemberNo(rset.getInt("MEMBER_NO"));
				handover.setCreateDate(rset.getString("CREATE_DATE"));
				handover.setBoardCount(rset.getInt("BOARD_COUNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			close(rset);
		}
		return handover;
	}

	
	public ArrayList<BoardAttachment> selectHandOverAtt(Connection conn, int boardNo){
			
			ArrayList<BoardAttachment> att = new ArrayList();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectHandOverAtt");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, boardNo);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					BoardAttachment oA = new BoardAttachment();
					
					oA.setFileLevel(rset.getInt("FILE_LEVEL"));
					oA.setOriginName(rset.getString("ORIGIN_NAME"));
					oA.setFilePath(rset.getString("FILE_PATH"));
					oA.setFileNo(rset.getInt("FILE_NO"));
					oA.setBoardNo(rset.getInt("BOARD_NO"));
					
					att.add(oA);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return att;
			
		}
	public int insertHandOverBoard(Connection conn, HandOver ho) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertHandOverBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ho.getMemberNo());
			pstmt.setString(2, ho.getCategory());
			pstmt.setString(3, ho.getBoardTitle());
			pstmt.setString(4, ho.getBoardContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int insertHandOverAttachment(Connection conn, ArrayList<BoardAttachment> attList) {
		
		int result = 1;
		PreparedStatement pstmt = null;
		System.out.println(attList);
		
		String sql = prop.getProperty("insertHandOverAttachment");
		
		try {
			for(BoardAttachment att : attList) {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, att.getFileLevel());
				pstmt.setString(2, att.getOriginName());
				pstmt.setString(3, att.getChangeName());
				pstmt.setString(4, att.getFilePath());
				
				result *= pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	
	public int updateHandOverBoard(Connection conn, HandOver ho) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateHandOverBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ho.getBoardTitle());
			pstmt.setString(2, ho.getBoardContent());
			pstmt.setString(3, ho.getCategory());
			pstmt.setInt(4, ho.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int updateHandOverAttachment(Connection conn, ArrayList<BoardAttachment> attList) {
		
		int result = 1;
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("updateHandOverAttachment");
		
		try {
			
			for(BoardAttachment att : attList) {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, att.getOriginName());
				pstmt.setString(2, att.getChangeName());
				pstmt.setString(3, att.getFilePath());
				pstmt.setInt(4, att.getFileLevel());
				pstmt.setInt(5, att.getFileNo());
				pstmt.setInt(6, att.getBoardNo());
				
				result *= pstmt.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
		
	}
	
	public int newInsertHandOverAttachment(Connection conn, ArrayList<BoardAttachment> attList) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("newInsertHandOverAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(int i = 0; i < attList.size(); i++) {
				
				pstmt.setInt(1, attList.get(i).getBoardNo());
				pstmt.setInt(2, attList.get(i).getFileLevel());
				pstmt.setString(3, attList.get(i).getOriginName());
				pstmt.setString(4, attList.get(i).getChangeName());
				pstmt.setString(5, attList.get(i).getFilePath());
				
			}
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteHandOverBoard(Connection conn, int boardNo) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("deleteHandOverBoard");
			
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
