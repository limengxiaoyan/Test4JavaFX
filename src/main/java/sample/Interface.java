package sample;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import sample.kit.HttpUtil;
import sample.kit.ResponseData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenli on 2018/1/11 0011.
 */
public class Interface {
    private static String domain = "http://localhost:8088/hydatid/";

    /**
     * 登录接口
     * @param username
     * @param password
     * @return
     * @throws IOException
     */
    public static ResponseData login(String username,String password) throws IOException {
        String url = domain + "sick/login";
        Map<String,String> params = new HashMap<>();
        params.put("username",username);
        params.put("password",password);
        String send = HttpUtil.send(url, params);
        ResponseData responseData = JSON.parseObject(send, new TypeReference<ResponseData>() {});
        return responseData;

    }
}
