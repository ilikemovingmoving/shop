package com.taotao.common;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class TestFtp {

	public static void main(String[] args) throws Exception {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.1.40");
		ftpClient.login("ftpuser", "panxiwen123");
//		FileInputStream inputStream = new FileInputStream(new File("D:\\Documents\\Pictures\\pics\\21.jpg"));
		FileInputStream inputStream = new FileInputStream(new File("C:\\windows\\web\\screen\\img102.jpg"));
		
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		ftpClient.storeFile("123.jpg", inputStream);
		inputStream.close();
		
		ftpClient.logout();
	}

}
