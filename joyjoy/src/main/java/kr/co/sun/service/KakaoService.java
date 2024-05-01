package kr.co.sun.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class KakaoService {
     public String getReturnAccessToken(String code) {
         String access_token = "";
         String refresh_token = "";
         String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

             //HttpURLConnection 설정 값 셋팅
             conn.setRequestMethod("POST");
             conn.setDoOutput(true);


             // buffer 스트림 객체 값 셋팅 후 요청
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
             StringBuilder sb = new StringBuilder();
             sb.append("grant_type=authorization_code");
             sb.append("&client_id=6063711ce8fa1c4346c0542292be495a");  //앱 KEY VALUE
             sb.append("&redirect_uri=http://localhost:8080/kakao/callback"); // 앱 CALLBACK 경로
             sb.append("&code=" + code);
             bw.write(sb.toString());
             bw.flush();

             int responseCode = conn.getResponseCode();
             log.info("responseCode : " + responseCode);
             
             //  RETURN 값 result 변수에 저장
             BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
             String br_line = "";
             String result = "";

             log.info("response body : " + result);
             
             while ((br_line = br.readLine()) != null) {
                 result += br_line;
             }
             
             //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
             JsonParser parser = new JsonParser();
             JsonElement element = parser.parse(result);

             // 토큰 값 저장 및 리턴
             access_token = element.getAsJsonObject().get("access_token").getAsString();
             refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();

             log.info("access_token : " + access_token);
             log.info("refresh_token : " + refresh_token);
             
             br.close();
             bw.close();
         } catch (IOException e) {
             e.printStackTrace();
         }

         return access_token;
     }

     public Map<String,Object> getUserInfo(String access_token) {
         Map<String,Object> resultMap =new HashMap<>();
         String reqURL = "https://kapi.kakao.com/v2/user/me";
          try {
              URL url = new URL(reqURL);
              HttpURLConnection conn = (HttpURLConnection) url.openConnection();
              conn.setRequestMethod("GET");

             //요청에 필요한 Header에 포함될 내용
              conn.setRequestProperty("Authorization", "Bearer " + access_token);

              int responseCode = conn.getResponseCode();
              System.out.println("responseCode : " + responseCode);

              BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

              String br_line = "";
              String result = "";

              while ((br_line = br.readLine()) != null) {
                  result += br_line;
              }
             System.out.println("response:" + result);

              JsonParser parser = new JsonParser();
              JsonElement element = parser.parse(result);
              log.warn("element:: " + element);
              JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
              JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
              log.warn("id:: "+element.getAsJsonObject().get("id").getAsString());
              String id = element.getAsJsonObject().get("id").getAsString();
              String nickname = properties.getAsJsonObject().get("nickname").getAsString();
              String email = kakao_account.getAsJsonObject().get("email").getAsString();
              log.warn("email:: " + email);
              resultMap.put("nickname", nickname);
              resultMap.put("id", id);
              resultMap.put("email", email); 

          } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
          return resultMap;
      }
}