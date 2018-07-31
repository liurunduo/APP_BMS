package com.lrd.util;

import java.io.File;
import java.io.IOException;

import javax.swing.text.rtf.RTFEditorKit;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	public static String fileUpload(MultipartFile photo,String contextPath){
		int rand = (int)(Math.random()*9000)+1000;
		String fileName = System.currentTimeMillis()+""+rand+photo.getOriginalFilename();
		File file =new File(contextPath, fileName);
		try {
			photo.transferTo(file);
			/*return File.separator+"statics"+File.separator+
					"uploadfiles"+File.separator+fileName;*/
			return fileName;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	public static boolean deleteFile(String fileName){
		 File file = new File(fileName);
		  // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		 if (file.exists() && file.isFile()) {
			if (file.delete()) {
				return true;
			}
		 }else{
			 System.out.println("文件"+fileName+"不存在！");
		 }
		 return false;
	}
}
