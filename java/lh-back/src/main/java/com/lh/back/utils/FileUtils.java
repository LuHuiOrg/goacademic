package com.lh.back.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author carlsummer
 * @date 2017年9月17日
 * @version 1.0
 * @Copyright
 */
public class FileUtils {
	
	public static boolean deleteFileFromDisk(String deleteFullFilename){
		File tempFile = new File(ConfigUtils.getConfig("vedio.path").toString()+SftpUtils.getFilename(deleteFullFilename));
        if (tempFile.exists()) {
            tempFile.delete();
        }
        return true;
	}

	public static void saveFileToDisk(InputStream inputStream, String fileName) {
        OutputStream os = null;
        try {
            String path = ConfigUtils.getConfig("vedio.path").toString();
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
