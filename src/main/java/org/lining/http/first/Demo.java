package org.lining.http.first;

import org.apache.http.*;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.message.BasicHttpResponse;

/**
 * description:
 * date 2017/10/11
 *
 * @author lining1
 * @version 1.0.0
 */
public class Demo {

    public static void main(String[] args) {
        HttpRequest request = new BasicHttpRequest("GET", "/", HttpVersion.HTTP_1_1);
        System.out.println(request.toString());
        System.out.println(request.getRequestLine().getMethod());
        System.out.println(request.getRequestLine().getUri());
        System.out.println(request.getProtocolVersion());
        System.out.println(request.getRequestLine().toString());

        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();

        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"OK");
        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(response.getStatusLine().toString());

        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();

        response.addHeader("Set-Cookie", "c1=a; path=/; domain=localhost");
        Header h1 = response.getFirstHeader("Set-Cookie");
        System.out.println(h1);
        response.addHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"localhost\"");
        Header h2 = response.getLastHeader("Set-Cookie");
        System.out.println(h2);
        Header[] hs = response.getHeaders("Set-Cookie");
        System.out.println(hs.length);

        HeaderIterator it = response.headerIterator("Set-Cookie");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        HeaderElementIterator itt = new BasicHeaderElementIterator(
                response.headerIterator("Set-Cookie"));
        while (itt.hasNext()) {
            HeaderElement elem = itt.nextElement();
            System.out.println(elem.getName() + " = " + elem.getValue());
            NameValuePair[] params = elem.getParameters();
            for (int i = 0; i < params.length; i++) {
                System.out.println(" " + params[i]);
            }
        }
    }
}
