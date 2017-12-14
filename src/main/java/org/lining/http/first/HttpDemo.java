package org.lining.http.first;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * description:
 * date 2017/10/11
 *
 * @author lining1
 * @version 1.0.0
 */
public class HttpDemo {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://localhost/");
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                try {
                    System.out.println(instream.toString());
                } finally {
                    instream.close();
                }
            }
        } finally {
            response.close();
        }

        File file = new File("somefile.txt");
        FileEntity entity = new FileEntity(file, ContentType.create("text/plain", "UTF-8"));
        HttpPost httppost = new HttpPost("http://localhost/action.do");
        httppost.setEntity(entity);

        StringEntity entity2 = new StringEntity("important message",
                ContentType.create("plain/text", Consts.UTF_8));
        entity.setChunked(true);
        HttpPost httppost2 = new HttpPost("http://localhost/acrtion.do");
        httppost2.setEntity(entity2);
    }
}
