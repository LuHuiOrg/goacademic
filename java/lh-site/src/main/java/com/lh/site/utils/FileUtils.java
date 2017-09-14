package com.lh.site.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

	/**
	 * eg FileUtils.readFileToResponse("D:/workspace/zhouyaning/WebContent/09/f1c3140516~1.flv", "f1c3140516~1", response)
	 * @param fileUrl
	 * @param fileName
	 * @param response
	 */
	@SuppressWarnings("unused")
	public static void readFileToResponse(String fileUrl,String fileName,HttpServletResponse response){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fileUrl = new String(fileUrl.getBytes("utf-8"), "utf-8");
			response.setContentType("application/x-msdownload");
			response.setCharacterEncoding("utf-8");
			String iso_filename = new String(fileName.getBytes("GBK"), "ISO-8859-1");
			response.setHeader("Content-disposition", "attachment; filename=" + iso_filename);
			// 通知客户文件的MIME类型：
			bis = new BufferedInputStream(new FileInputStream((fileUrl)));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			int i = 0;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
				i++;
			}bos.flush();
		} catch (Exception e) {
			logger.error("process transaction error", e);
		} finally {
			if (bis != null) {try {bis.close();} catch (IOException e) {e.printStackTrace();}bis = null;}
			if (bos != null) {try {bos.close();} catch (IOException e) {e.printStackTrace();}
			bos = null;
			}
		}
	}
	
	/**
	 * eg FileUtils.readUrlFileToResponse("http://47.92.123.48/images/cover/f1c3140516~1.flv", UUID.randomUUID().toString(), response);
	 * @param fileUrl
	 * @param fileName
	 * @param response
	 */
	@SuppressWarnings("unused")
	public static void readUrlFileToResponse(String fileUrl,String fileName,HttpServletResponse response){
		InputStream br = null;
		BufferedOutputStream bos = null;
		try {
			fileUrl = new String(fileUrl.getBytes("utf-8"), "utf-8");
			URL urla = new URL(fileUrl);
			br = urla.openStream();
			response.setContentType("application/x-msdownload");
			response.setCharacterEncoding("utf-8");
			String iso_filename = new String(fileName.getBytes("GBK"), "ISO-8859-1");
			response.setHeader("Content-disposition", "attachment; filename=" + iso_filename);
			// 通知客户文件的MIME类型：
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			int i = 0;
			while (-1 != (bytesRead = br.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
				i++;
			}bos.flush();
		} catch (Exception e) {
			logger.error("process transaction error", e);
		} finally {
			if (br != null) {try {br.close();} catch (IOException e) {e.printStackTrace();}br = null;}
			if (bos != null) {try {bos.close();} catch (IOException e) {e.printStackTrace();}bos = null;}
		}
	}
}
