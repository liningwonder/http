package org.lining.http.first;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * description:
 * date 2017/10/11
 *
 * @author lining1
 * @version 1.0.0
 */
public class EntityDemo {

    public static void main(String[] args) throws IOException {
        StringEntity myEntity = new StringEntity("important message", Consts.UTF_8);
        System.out.println(myEntity.getContentType());
        System.out.println(myEntity.getContentLength());
        System.out.println(EntityUtils.toString(myEntity));
        System.out.println(EntityUtils.toByteArray(myEntity).length);

        StringBuilder sb = new StringBuilder();
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> envEntry : env.entrySet()) {
            sb.append(envEntry.getKey())
                    .append(": ").append(envEntry.getValue())
                    .append("\r\n");
        }
        HttpEntity myEntity1 = new StringEntity(sb.toString());
        System.out.println(EntityUtils.toString(myEntity1));
        HttpEntity myEntity2 = new StringEntity(sb.toString(), Consts.UTF_8);
        System.out.println(EntityUtils.toString(myEntity2));
        HttpEntity myEntity3 = new StringEntity(sb.toString(), ContentType.create("text/plain", Consts.UTF_8));
        System.out.println(EntityUtils.toString(myEntity3));
    }
}
