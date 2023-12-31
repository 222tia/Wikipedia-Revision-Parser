package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class URL extends User{
    protected String createURL() {
        String searchRequest = getUserSearchRequest();
        String articleTitle = URLEncoder.encode(searchRequest, Charset.defaultCharset());

        return String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=27&redirects", articleTitle);

    }

    public InputStream connectURL() {
        String urlString = createURL();
        try {

            java.net.URL url = new java.net.URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "Revision Reporter/0.1 (nrhively@bsu.edu)");

            return connection.getInputStream();

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }
}