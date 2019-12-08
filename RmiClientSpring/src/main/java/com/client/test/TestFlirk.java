package com.client.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.client.utils.FlickrService;

public class TestFlirk {

	public static void main(String[] args) {
		FlickrService.getToken();
		
		/*try {
			InputStream stream = new FileInputStream(new File("D:\\default.png"));
			String url = FlickrService.upload(stream, "default");
			System.out.println("Photo added "+url);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

	}

}
