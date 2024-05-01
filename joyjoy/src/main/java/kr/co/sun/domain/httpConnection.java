package kr.co.sun.domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;




public class httpConnection {
	
	public static final String ENCODING = "UTF-8";
	
	private httpConnection(){}
	
	private static class httpConnection_Singleton {
		private static final httpConnection instance = new httpConnection();
	}
	
	public static httpConnection getInstance() {
		return httpConnection_Singleton.instance;
	}
	
	// get방식 rest 호출 시 사용
	public StringBuffer HttpGetConnection(String apiURL) throws IOException {
		
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		
		return responseHttp(con);
	}
	
	// post방식 rest 호출 시 사용
	public StringBuffer HttpPostConnection(String apiURL, Map<String, String> params) throws IOException {
		
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		
		// 만약에 파라미터에 Authorization이 있다면 헤더로 추가 후 params에서 제거
		if (params.get("Authorization") != null) {
			con.setRequestProperty("Authorization", params.get("Authorization"));
			params.remove("Authorization");
		}
		
		// post request
		// 해당 string은 UTF-8로 encode 후 MS949로 재 encode를 수행한 값
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
		StringBuilder sb = new StringBuilder();
		
		int amp = 0;
		
		for (String key : params.keySet()) {
			// 2번째 파라미터부터는 구분자 &가 있어야한다.
			if (amp >= 1) sb.append("&"); amp += 1;
			
			sb.append(key+params.get(key));
		}
		
		System.out.println("파라미터 : " + sb.toString());
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		return responseHttp(con);
	}
	
	// 서버에 요청하는 메소드(응답처리)
	public StringBuffer responseHttp(HttpURLConnection con) throws IOException {
		
		StringBuffer response = new StringBuffer();
		
		int responseCode = con.getResponseCode();
		BufferedReader br;
		
		if (responseCode == 200) {  // 정상호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		String inputLine;
		
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		
		br.close();
		
		return response;
	}
	
	// 파라미터 URL 인코딩
	public String URLencoder(String contents) throws UnsupportedEncodingException {
		return URLEncoder.encode(URLEncoder.encode(contents, ENCODING), "MS949");
	}

}














