package com.client.utils;

import java.io.InputStream;

import javax.swing.JOptionPane;

import org.scribe.model.Token;
import org.scribe.model.Verifier;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;


public class FlickrService{
	
	private static Flickr flick;
	
	private static UploadMetaData data = new UploadMetaData();
	
	private static final String apiKey = "f74e0f5bc25f9e0204c90b671580c10c";
	
	private static final String sharedSecret = "f14434e07b44b9b0";
	
	private static final String token = "72157711614887766-38ec13de10bd3a1d";
	
	private static final String secret = "0211f9b73675c171";
	
	private static void auth() {
		flick = new Flickr(apiKey, sharedSecret, new REST());
		Auth auth= new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken(token);
		auth.setTokenSecret(secret);
		RequestContext context = RequestContext.getRequestContext();
		context.setAuth(auth);
		flick.setAuth(auth);
	}
	
	public static String upload(InputStream stream, String fileName) throws Exception {
		auth();
		data.setTitle(fileName);
		String id = flick.getUploader().upload(stream, data);
		return flick.getPhotosInterface().getPhoto(id).getMedium640Url();
	}
	
	public static void getToken() {
		Flickr flickr = new Flickr(apiKey, sharedSecret, new REST());
		AuthInterface authInterface = flickr.getAuthInterface();
		//OAuth1RequestToken token = authInterface.getRequestToken();
		Token token = authInterface.getRequestToken();
		
		System.out.println("Token: "+token);
		
		String url = authInterface.getAuthorizationUrl(token, Permission.DELETE);
		System.out.println("***Generation du token***");
		System.out.println("Ulr: "+url);
		
		String tokenKey = JOptionPane.showInputDialog(null);
		
		//OAuth1Token requestToken = authInterface.getAccessToken(token, tokenKey);
		Token requestToken = authInterface.getAccessToken(token, new Verifier(tokenKey));
				
		Auth auth = null;
		try {
			auth = authInterface.checkToken(requestToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Token: "+requestToken.getToken());
		//System.out.println("Secret: "+requestToken.getTokenSecret());
		System.out.println("Secret: "+requestToken.getSecret());
		System.out.println("usid: "+auth.getUser().getId());
		System.out.println("RealName: "+auth.getUser().getRealName());
		System.out.println("Username: "+auth.getUser().getUsername());
		System.out.println("Permission: " + auth.getPermission().getType());
	}

}
