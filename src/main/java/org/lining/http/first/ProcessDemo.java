package org.lining.http.first;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.*;

import java.io.IOException;

/**
 * description:
 * date 2017/10/11
 *
 * @author lining1
 * @version 1.0.0
 */
public class ProcessDemo {

    public static void main(String[] args) throws IOException, HttpException {
        HttpProcessor httpproc = HttpProcessorBuilder.create()
                .add(new RequestContent())
                .add(new RequestTargetHost())
                .add(new RequestConnControl())
                .add(new RequestUserAgent("MyAgent-HTTP/1.1"))
                .add(new RequestExpectContinue(true))
                .build();
        HttpCoreContext context = HttpCoreContext.create();
        HttpRequest request = new BasicHttpRequest("GET", "/");
        httpproc.process(request, context);
    }
}
