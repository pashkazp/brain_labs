package ua.zp.brain.labs.oop.basics.lab31;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class IpInfo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://ipgeobase.ru:7020/geo?ip=77.93.33.137");
        //URL url = new URL("http://witest.ru/remoting/get_local_ip_address/");
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();

        System.out.println("Date: " + urlConn.getDate());
        System.out.println("Type: " + urlConn.getContentType());
        System.out.println("Exp: " + urlConn.getExpiration());
        System.out.println("Last Modify: " + new Date(urlConn.getLastModified()));
        System.out.println("Length: " + urlConn.getContentLength());
        System.out.println(urlConn.getResponseMessage());
        urlConn.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String s;
        if (urlConn.getContentLength() > 0){
            while (( s = br.readLine())!= null){
                sb.append(s).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
