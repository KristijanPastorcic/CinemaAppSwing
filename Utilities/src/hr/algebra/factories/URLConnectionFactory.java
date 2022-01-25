/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.factories;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author islan
 */
public class URLConnectionFactory {

    private URLConnectionFactory() {
    }

    public static HttpURLConnection createHttpURLConnection(String urlPath)
            throws MalformedURLException, IOException {
        URL url = new URL(urlPath);
        HttpURLConnection connection
                = (HttpURLConnection) url.openConnection();

        // must set 
        connection.setConnectTimeout(TIMEOUT);
        connection.setReadTimeout(TIMEOUT);
        connection.setRequestMethod(REQUEST_METHOD);

        // also must set, https://webaim.org/blog/user-agent-string-history/
        connection.addRequestProperty(USER_AGENT, MOZILLA);
        return connection;
    }
    
    private static final String MOZILLA = "Mozilla/5.0";
    private static final String USER_AGENT = "user-agent";
    private static final String REQUEST_METHOD = "GET";
    private static final int TIMEOUT = 10000;

}
