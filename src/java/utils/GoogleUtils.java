/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import google.GoogleConstants;
import google.GooglePojo;

/**
 *
 * @author Admin
 */
public class GoogleUtils {
    
     public static String getToken(final String code) throws ClientProtocolException, IOException {
    String response = Request.Post(GoogleConstants.GOOGLE_LINK_GET_TOKEN)
        .bodyForm(Form.form().add("client_id", GoogleConstants.GOOGLE_CLIENT_ID)
            .add("client_secret", GoogleConstants.GOOGLE_CLIENT_SECRET)
            .add("redirect_uri",GoogleConstants.GOOGLE_REDIRECT_URI).add("code", code)
            .add("grant_type", GoogleConstants.GOOGLE_GRANT_TYPE).build())
        .execute().returnContent().asString();
      JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
      String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
      return accessToken;
  }
    public static GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
    String link = GoogleConstants.GOOGLE_LINK_GET_USER_INFO + accessToken;
    String response = Request.Get(link).execute().returnContent().asString();
    GooglePojo accountGG = new Gson().fromJson(response, GooglePojo.class);
    System.out.println(accountGG);
    return accountGG;
  }
    
}
