package com.client.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.Part;

import com.server.utils.EncodeSha;

public class FileManager {
	
	private FileManager() {
		super();
	}
	
	/**
	 * Prend en entrée un fichier de type Part puis retourne l'url de l'image téléchargé
	 * @param file
	 * @return
	 */
	public static String upload(Part file) {
		String url=null;
		String id = EncodeSha.getHash((new Date()).toString());
		if(file!=null) {
			InputStream stream = null;
			try {
				stream = file.getInputStream();;
				url=FlickrService.upload(stream, "image_"+id);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			//return url;
		}
		return url;
	}
}
