package com.leifeng.base.module.net;

import android.text.TextUtils;
import com.cnlive.module.base.utils.LogUtil;
import okhttp3.*;
import okio.Buffer;
import okio.BufferedSource;

import java.io.IOException;
import java.nio.charset.Charset;

import static java.lang.Long.MAX_VALUE;

public class LogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl mHttpUrl = request.url();
        LogUtil.i("请求头：" + request.headers());
        LogUtil.i("请求方式：" + request.method());
        RequestBody requestBody = request.body();
        if (requestBody != null && requestBody.contentLength() != 0L) {
            Buffer requestBuffer = new Buffer();
            requestBody.writeTo(requestBuffer);
            String requestParamsStr = requestBuffer.readString(Charset.forName("UTF-8"));
            LogUtil.i("请求参数", "(" + requestParamsStr.replace("&", ",") + ")");
        }

        LogUtil.i("请求地址：" + mHttpUrl.url().toString());
        Response response = chain.proceed(request);
        ResponseBody body = response.body();
        if (body != null && body.contentLength() != 0L){
            BufferedSource source = body.source();
            source.request(MAX_VALUE);
            Buffer buffer = source.buffer();
            LogUtil.i(String.format("请求返回数据：%s", decodeUnicode(buffer.clone().readString(Charset.forName("UTF-8")))));
        }
        return response;
    }

    /**
     * http 请求数据返回 json 中中文字符为 unicode 编码转汉字转码
     *
     * @param theString 转换字符串
     * @return 转化后的结果.
     */
    public static String decodeUnicode(String theString) {
        if (TextUtils.isEmpty(theString)) return "";
        char aChar;
        int len = theString.length();
        StringBuilder outBuffer = new StringBuilder(len);
        for (int x = 0; x < len; ) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }

                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }
}
