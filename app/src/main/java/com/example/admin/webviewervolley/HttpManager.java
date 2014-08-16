package com.example.admin.webviewervolley;

/**
 * Created by admin on 8/16/2014.
 */
        import android.util.Base64;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;

/**
 * Created by admin on 7/21/2014.
 */
public class HttpManager{

    public static String getData(String uri){

        BufferedReader reader = null;

        try {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = reader.readLine())!=null){
                sb.append(line+"\n");
            }

            return sb.toString();

        } catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
    public static String getData(String uri, String userName, String password){

        BufferedReader reader = null;
        HttpURLConnection conn = null;

        byte[] loginBytes = (userName+":"+password).getBytes();
        StringBuilder loginBuilder = new StringBuilder()
                .append("Basic ")
                .append(Base64.encodeToString(loginBytes, Base64.DEFAULT));


        try {
            URL url = new URL(uri);
            conn = (HttpURLConnection) url.openConnection();

            conn.addRequestProperty("Authorization",loginBuilder.toString());

            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = reader.readLine())!=null){
                sb.append(line+"\n");
            }

            return sb.toString();

        } catch (Exception e){
            e.printStackTrace();
            try {
                int status = conn.getResponseCode();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return  null;
        }
        finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}
