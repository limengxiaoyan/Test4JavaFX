package sample.kit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenli on 2018/1/9 0009.
 */
public class HttpUtil {
    private static Log log = LogFactory.getLog("http工具类");

    /**
     * @param url    String 请求地址
     * @param params Map<String, String> 请求参数
     * @return
     * @throws IOException
     */
    public static String send(String url, Map<String, String> params) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        // 设置请求的header
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (StringUtils.isNotEmpty(entry.getKey()) && StringUtils.isNotEmpty(entry.getValue())) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        System.out.println("\n nvps:" + nvps);
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        System.out.println("\n httpPost:" + httpPost);
        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        System.out.println("\n response:" + response.getStatusLine());
        // 打印执行结果
        String res = EntityUtils.toString(response.getEntity(), "utf-8");
        log.debug("\n res:" + res);
        System.out.println("\n res:" + res);
        return res;
    }
}
