package com.kh.board.offer.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.offer.model.dao.OfferDao;
import com.kh.board.offer.model.vo.OfferAttachment;
import com.kh.board.offer.model.vo.OfferBoard;
import com.kh.common.model.vo.PageInfo;

public class OfferService {
   /*
   public ArrayList<OfferBoard> selectOfferList(){
      
      // Connection 객체 생성
      Connection conn = getConnection();
      
      // 받은 데이터없으니 바로 OfferDao로 넘겨줌
      ArrayList<OfferBoard> list = new OfferDao().selectOfferList(conn);
      
      close(conn);
      
      return list;
   }
   */
   // 게시판 페이징 처리
   public int selectListCount() {
      
      Connection conn = getConnection();
      
      int listCount = new OfferDao().selectListCount(conn);
      
      close(conn);
      
      return listCount;
      
   }
   
   // 게시판 리스트 조회
   public ArrayList<OfferBoard> selectOfferList(PageInfo pi){
      
      // Connection 객체 생성
      Connection conn = getConnection();
      
      // 받은 데이터없으니 바로 OfferDao로 넘겨줌
      ArrayList<OfferBoard> list = new OfferDao().selectOfferList(conn, pi);
      
      
      close(conn);
      
      return list;
   }
   
   // 게시글 작성
   public int insertOffer(OfferBoard oB, ArrayList<OfferAttachment> oAList) {
      
      Connection conn = getConnection();
      
      int result1 = new OfferDao().insertOfferBoard(conn, oB);
      System.out.println("result1 : " + result1);
      int result2 = new OfferDao().insertOfferAttachment(conn, oAList);
      System.out.println("result2 : " + result2);
      
      result2=1;
      if((result1 * result2) > 0) {
         commit(conn);
      } else {
         rollback(conn);
      }
      close(conn);
      
      return (result1 * result2);
   }
   
   // 게시글 상세조회 (게시판)
   public OfferBoard offerDetailView(int boardNo) {
      
      Connection conn = getConnection();
      
      OfferBoard oB = new OfferDao().offerDetailView(conn, boardNo);
      
      close(conn);
      
      return oB;
   }
   
   // 게시글 상세조회 (첨부파일)
   public ArrayList<OfferAttachment> offerAttachmentDetailView(int boardNo){
      
      Connection conn = getConnection();
      
      ArrayList<OfferAttachment> oAList = new OfferDao().offerAttachmentDetailView(conn, boardNo);
      
      close(conn);
      
      return oAList;
   }
   
   // 조회수 증가
   public int offerIncreaseCount(int boardNo) {
      
      Connection conn = getConnection();
      
      int result = new OfferDao().offerIncreaseCount(conn, boardNo);
      
      if(result > 0) {
         commit(conn);
      } else {
         rollback(conn);
      }
      
      close(conn);
      
      return result;
   }
   
   public int updateOfferBoard(OfferBoard oB, ArrayList<OfferAttachment> oAList) {
      
      Connection conn = getConnection();
      
      int result1 = new OfferDao().updateOfferBoard(conn, oB);
      
      for(OfferAttachment oA : oAList) {
         
         if(oA.getFileNo() != 0) {
            System.out.println((oA.getFileNo()) + "업데이트할때의 file번호");
            System.out.println(oA + "업데이할때의 oA객체");
            int result2 = new OfferDao().updateOfferAttachment(conn, oAList);
            System.out.println(result2 + "업데이트한 결과값");
         } else {
            int result2 = new OfferDao().newInsertOfferAttachment(conn, oAList);
            System.out.println(result2 + "새롭게 insert되는 첨부파일 결과값");
         }
         
      }
      int result2 = 1;
         /*
         for(int i = 0; i < 4; i++) {
            
            if(oAList.get(i).getFileNo() != 0) {
               // 기존에 첨부파일이 있었을 경우 => update
               result2 = new OfferDao().updateOfferAttachment(conn, oAList);
               System.out.println(result2 + "업데이트한 결과값");
            } else {
               //기존에 첨부파일이 없었을 경우 => insert
               result2 = new OfferDao().newInsertOfferAttachment(conn, oAList);
               System.out.println(result2 + "새롭게 insert되는 첨부파일 결과값");
            }
         }  // 첨부파일이 있었을 경우 for
      */
         
       // 새롭게 첨부파일이 있었을 경우 if문
      
      if((result1 * result2) > 0) {
         commit(conn);
         System.out.println("커밋성공");
      } else {
         rollback(conn);
         System.out.println("응 롤백");
      }
      
      close(conn);
      
      System.out.println(result1 * result2);
      
      return (result1 * result2);
   }
   
   public int deleteOfferBoard(int boardNo) {
      
      Connection conn = getConnection();
      
      int result = new OfferDao().deleteOfferBoard(conn, boardNo);
      
      if(result > 0) {
         commit(conn);
      } else {
         rollback(conn);
      }
      
      close(conn);
      
      return result;
   }
   
   

}