package org.lining.http.first;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * description:
 * date 2017/10/11
 *
 * @author lining1
 * @version 1.0.0
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException, URISyntaxException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget1 = new HttpGet("http://localhost/");
        CloseableHttpResponse response = httpclient.execute(httpget1);

        HttpGet httpget2 = new HttpGet(
                "http://www.google.com/search?hl=en&q=httpclient&btnG=Google+Search&aq=f&oq=");

        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.google.com")
                .setPath("/search")
                .setParameter("q", "httpclient")
                .setParameter("btnG", "Google Search")
                .setParameter("aq", "f")
                .setParameter("oq", "")
                .build();

        HttpGet httpget3 = new HttpGet(uri);
        System.out.println(httpget3.getURI());
    }
}
