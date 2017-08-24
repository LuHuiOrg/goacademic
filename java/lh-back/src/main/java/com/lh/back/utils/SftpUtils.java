package com.lh.back.utils;

import java.io.File;  
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;  
import com.jcraft.jsch.ChannelSftp;  
import com.jcraft.jsch.JSch;  
import com.jcraft.jsch.Session;  
  
public class SftpUtils {  
	
	private static final Logger logger = LoggerFactory.getLogger(SftpUtils.class);
      
    private static final String host = ConfigUtils.getConfig("ftp.url");  
    private static final String username=ConfigUtils.getConfig("ftp.user");  
    private static final String password=ConfigUtils.getConfig("ftp.password");  
    private static final int port = Integer.parseInt(ConfigUtils.getConfig("ftp.port").toString());  
    private static ChannelSftp sftp = new ChannelSftp();  
      
    /** 
     * connect server via sftp 
     */  
    public static void connect() {  
        try {  
            JSch jsch = new JSch();  
            jsch.getSession(username, host, port);  
            Session sshSession = jsch.getSession(username, host, port);  
            sshSession.setPassword(password);  
            Properties sshConfig = new Properties();  
            sshConfig.put("StrictHostKeyChecking", "no");  
            sshSession.setConfig(sshConfig);  
            sshSession.connect();  
            Channel channel = sshSession.openChannel("sftp");  
            channel.connect();  
            sftp = (ChannelSftp) channel;  
        } catch (Exception e) {  
        	logger.error("连接sftp异常", e); 
        	e.printStackTrace();
        }  
    }  
    /** 
     * Disconnect with server 
     */  
    public static void disconnect() {  
        if(sftp != null){  
            if(sftp.isConnected()){  
                sftp.disconnect();  
            }else if(sftp.isClosed()){  
                System.out.println("sftp is closed already");  
            }  
        }  
  
    }  
  
    
	/**
	 * 下载文件eg:download("/root/","6.jpg","C:/Users/zeng_xiaohui/Desktop/7879898.jpg");
	 * @param directory
	 * @param downloadFile
	 * @param saveFile
	 * @return
	 */
	@SuppressWarnings("unused")
	private static boolean download(String directory, String downloadFile,String saveFile) {  
        try {  
        	connect();  
            sftp.cd(directory);  
            File file = new File(saveFile);  
            sftp.get(downloadFile, new FileOutputStream(file));  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;
        } finally{
        	disconnect();
        }
        return true;
    }  
      
    /** 
     * upload all the files to the server 
     */  
    public static boolean uploadSFtp(String uploadFullFilename, InputStream file,String deleteFullFilename) {  
    	String uploadPath = getPath(uploadFullFilename);
		String uploadFilename = getFilename(uploadFullFilename);
    	try {  
    		uploadPath = new String(uploadPath.getBytes("UTF8"), "iso-8859-1");// 解决目录中文乱码
			uploadFilename = new String(uploadFilename.getBytes("UTF8"), "iso-8859-1");// 解决文件名中文乱码
        	connect();  
        	sftp.cd(uploadPath);
            sftp.put(file, uploadFilename); 
            if(!StringUtils.isBlank(deleteFullFilename)){
            	sftp.rm(getFilename(deleteFullFilename));
            }
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;
        } finally{
        	disconnect();
        }
    	return true;
    }  
    
    public static boolean delete(String directory, String deleteFile){
        try {
        	connect();  
            sftp.cd(directory);
            sftp.rm(getFilename(deleteFile));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally{
        	disconnect();
        }
        return true;
    }
    
    /**
	 * 获取路径
	 * 
	 * @param fullFilename
	 * @return
	 */
	public static String getPath(String fullFilename) {
		int lastIndex = fullFilename.lastIndexOf("/");
		if (lastIndex != -1) {
			return fullFilename.substring(0, lastIndex + 1);
		} else {
			return null;
		}
	}
	
	/**
	 * 获取文件名
	 * 
	 * @param fullFilename
	 *            包含路径的文件名
	 * @return
	 */
	public static String getFilename(String fullFilename) {
		int lastIndex = fullFilename.lastIndexOf("/");
		if (lastIndex != -1) {
			return fullFilename.substring(lastIndex + 1);
		} else {
			return null;
		}
	}
    
    /**
	 * 获取文件名后缀
	 * 
	 * @param filename
	 *            文件名
	 */
	public static String getSuffix(String filename) {
		return filename.substring(filename.lastIndexOf("."));
	}
    
    /**
	 * 根据上传的文件名生成新文件名
	 * 
	 * @param oldFilename
	 * @return
	 */
	public static String getNewFilename(String oldFilename) {
		return UUID.randomUUID() + getSuffix(oldFilename);
	}

    
  
  
}  