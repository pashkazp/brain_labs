package ua.zp.brain.labs.oop.basics.lab31;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class TestURL {
    public static void main(String[] args) throws Exception {
    int c;
    URL url = new URL("https://code.jquery.com/jquery-3.3.1.min.js");
    URLConnection urlConn = url.openConnection();
    System.out.println("Date: " + urlConn.getDate());
    System.out.println("Type: " + urlConn.getContentType());
    System.out.println("Exp: " + urlConn.getExpiration());
    System.out.println("Last Modify: " + new Date(urlConn.getLastModified()));
    System.out.println("Length: " + urlConn.getContentLength());
    if (urlConn.getContentLength() > 0) {
        System.out.println("=== Content ===");
        try(InputStream input = urlConn.getInputStream()) {
            int i = urlConn.getContentLength();
            while (((c = input.read()) != -1) && (--i > 0)) {
                System.out.print((char) c);
            }
        }
    } else {
        System.out.println("No Content Available");
    }
}
}
