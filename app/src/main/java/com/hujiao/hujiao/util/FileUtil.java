package com.hujiao.hujiao.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Environment;

public class FileUtil {
	public static final String LOG_DIR = "hujiao";

	public static void saveLogToFile(String content, String aFileName) {

		String fileName = getAppSDCardFileDir();
		if (fileName == null)
			return;
		fileName = fileName + "/" + aFileName;

		try {
			new File(fileName).createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(fileName, true);
			writer.write("\r\n-------------------" + getFormatNowDate() + "-------------------\r\n");
			writer.write(content);
			writer.write("\r\n-------------------" + getFormatNowDate() + "-------------------\r\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getFormatNowDate() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		return retStrFormatNowDate;
	}

	public static String getAppSDCardFileDir() {
		File sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED); // 判断sd卡
		if (sdCardExist) {
			File f = Environment.getExternalStorageDirectory();
			sdDir = new File(f, LOG_DIR);
			if (!sdDir.exists()) {
				sdDir.mkdir();
			}
		}
		if (sdDir == null)
			return null;

		return sdDir.toString();
	}
}
