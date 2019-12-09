package com.client.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	private FileManager() {
		super();
	}
	
	/**
	 * Prend en entrée un fichier de type Part puis retourne l'url de l'image téléchargé
	 * @param file
	 * @return
	 */
	public static String upload(MultipartFile file) {
		String url=null;
		if(file!=null) {
			InputStream stream = null;
			try {
				stream = file.getInputStream();
				url=FlickrService.upload(stream, genarateRandomString());
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return url;
	}
	
	
	private static String genarateRandomString() {
		byte[] array = new byte[7];
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    return generatedString;
	}
}
