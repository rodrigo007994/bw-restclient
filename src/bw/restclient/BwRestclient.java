/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bw.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.commons.io.IOUtils;
public class BwRestclient {
    
    /*public static void main(String[] args){
    //System.out.println(HttpPost("https://www.w3schools.com/php/welcome.php",new String[][]{{"name","rodrigo"},{"email","rodrigovoperamail.com"}}));
    System.out.println(HttpGet("https://www.w3schools.com/php/welcome_get.php",new String[][]{{"name","rodr igo"},{"email","rodrigovoper  amail.com"},{"email","rodrigovop  eramail.com"}}));
    
    }*/
    
    public static String HttpGet(String url, String[][] parameters) {
        String out=null;
        try {
             HttpClient client = new DefaultHttpClient();
             for(int i = 0; i < parameters.length; i++){
                if(i==0){
                    url=url+"?"+URLEncoder.encode(parameters[i][0], "UTF-8")+"="+URLEncoder.encode(parameters[i][1], "UTF-8");
                }else{
                    url=url+"&"+URLEncoder.encode(parameters[i][0], "UTF-8")+"="+URLEncoder.encode(parameters[i][1], "UTF-8");
                }
                 
            }
  HttpGet request = new HttpGet(url);
  System.out.println(url);
  HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            out = IOUtils.toString(rd);
        
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BwRestclient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BwRestclient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }

    public static String HttpPost(String url, String[][] parameters) {
        String out=null;
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            List nameValuePairs = new ArrayList(parameters.length);
           for(int i = 0; i < parameters.length; i++){
                nameValuePairs.add(new BasicNameValuePair(URLEncoder.encode(parameters[i][0], "UTF-8"), URLEncoder.encode(parameters[i][1], "UTF-8")));
            }
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            out = IOUtils.toString(rd);
        
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BwRestclient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BwRestclient.class.getName()).log(Level.SEVERE, null, ex);
        }
            return out;
 

    
    

    }
}