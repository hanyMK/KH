package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {
   
   @Override
   public File rename(File originFile) {
      
      // 매개변수로 전달받은 원본 파일로 부터 원본 파일명을 뽑아서 변수에 담아준다
      String originName = originFile.getName();

      // 1) 파일이 업로드된 시간을 추출한다.
      String currentTime = new SimpleDateFormat("yyyMMddHHmmss").format(new Date());
      
      // 2) 랜덤값을 추출 해준다.
      int randomNumber = (int)(Math.random() * 90000) + 10000;
      
      // 3) 확장자를 뽑아 뒤에.을 붙이고 확장자 이름을 붙여준다
      String ext = originName.substring(originName.lastIndexOf("."));
      
      // 위에서 나눈것들을 모아서 최종수정파일명을 변수에 담아준다
      String changeFileName = "NoSweat_" + currentTime + "_" + randomNumber + ext;
      
      // 기존파일을 수정된 파일명으로 적용시켜서 반환시켜준다
      return new File(originFile.getParent(), changeFileName);
      
      
      
   }

}