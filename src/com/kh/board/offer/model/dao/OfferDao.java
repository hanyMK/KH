package com.kh.board.offer.model.dao;

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
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Member;

public class OfferDao {
   
   private Properties prop = new Properties();
   
   public OfferDao() {
      String fileName = OfferDao.class.getResource("/sql/board/offer/offer-mapper.xml").getPath();
      
      try {
         prop.loadFromXML(new FileInputStream(fileName));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   public ArrayList<OfferBoard> selectOfferList(Connection conn, PageInfo pi){
      
      ArrayList<OfferBoard> list = new ArrayList();
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("selectOfferList");
      //System.out.println(sql);
      try {
         pstmt = conn.prepareStatement(sql);
         
         int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
         int endRow = startRow + pi.getBoardLimit() -1;
         pstmt.setInt(1, startRow);
         pstmt.setInt(2, endRow);
         
         rset = pstmt.executeQuery();
         
         
         
         while(rset.next()) {
            OfferBoard oB = new OfferBoard();
            
            
            oB.setBoardTitle(rset.getString("BOARD_TITLE"));
            oB.setCategory(rset.getString("CATEGORY"));
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
   
   public int insertOfferBoard(Connection conn, OfferBoard oB) {
      
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("insertOfferBoard");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, oB.getNickName());
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
   
   public int insertOfferAttachment(Connection conn, ArrayList<OfferAttachment> oAList) {
      
      int result = 1;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("insertOfferAttachment");
      
      try {
         for(OfferAttachment oA : oAList) {
            
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
   
   public OfferBoard offerDetailView(Connection conn, int boardNo) {
      
      OfferBoard oB = new OfferBoard();
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("offerBoardDetail");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, boardNo);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            oB.setBoardNo(rset.getInt("BOARD_NO"));
            oB.setBoardTitle(rset.getString("BOARD_TITLE"));
            oB.setCategory(rset.getString("CATEGORY"));
            oB.setBoardContent(rset.getString("BOARD_CONTENT"));
            oB.setMemberNo(rset.getInt("MEMBER_NO"));
            oB.setNickName(rset.getString("NICKNAME"));
            oB.setEmail(rset.getString("EMAIL"));
            oB.setCreateDate(rset.getString("CREATE_DATE"));
            oB.setBoardCount(rset.getInt("BOARD_COUNT"));
            oB.setClosingDate(rset.getString("CLOSING_DATE"));
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
   
   public int offerIncreaseCount(Connection conn, int boardNo) {
      
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("offerIncreaseCount");
      
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
   
   public ArrayList<OfferAttachment> offerAttachmentDetailView(Connection conn, int boardNo){
      
      ArrayList<OfferAttachment> oAList = new ArrayList();
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("offerAttachmentDetailView");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, boardNo);
         
         rset = pstmt.executeQuery();
         
         while(rset.next()) {
            OfferAttachment oA = new OfferAttachment();
            
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
   
   public int updateOfferBoard(Connection conn, OfferBoard oB) {
      
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("updateOfferBoard");
      
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
   
   public int updateOfferAttachment(Connection conn, ArrayList<OfferAttachment> oAList) {
      
      int result = 0;
      PreparedStatement pstmt = null;
      
      
      String sql = prop.getProperty("updateOfferBoardAttachment");
      
      try {
         
         for(OfferAttachment oA : oAList) {
            
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
   
   public int newInsertOfferAttachment(Connection conn, ArrayList<OfferAttachment> oAList) {
      
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("newInsertOfferAttachment");
      
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
   
   public int deleteOfferBoard(Connection conn, int boardNo) {
      
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("deleteOfferBoard");
      
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