package com.flsrage.gptbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @version 1.0
 * @Author Flsrage
 * @Date 2023/8/6 14:47
 * @Description 单元测试
 */
public class ApiTest {
    @Test
    public void query_unanswered_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48884214455818/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie","zsxq_access_token=2ED1BA18-234C-9A12-D22C-168427702DFE_7BFE980F7EAC09A1; abtest_env=product; zsxqsessionid=5fb8a1ea0dfd6a0b85851f18af6dd11e; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22218848512488441%22%2C%22first_id%22%3A%22189c524ff8572f-085944324976c38-7c546c76-2073600-189c524ff86186c%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%AB%99%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fopen.weixin.qq.com%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5YzUyNGZmODU3MmYtMDg1OTQ0MzI0OTc2YzM4LTdjNTQ2Yzc2LTIwNzM2MDAtMTg5YzUyNGZmODYxODZjIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMjE4ODQ4NTEyNDg4NDQxIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22218848512488441%22%7D%2C%22%24device_id%22%3A%22189c524ff8572f-085944324976c38-7c546c76-2073600-189c524ff86186c%22%7D");
        get.addHeader("Content-Type","application/json; charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer_question() throws IOException{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/211884251214441/answer");
        post.addHeader("cookie","zsxq_access_token=2ED1BA18-234C-9A12-D22C-168427702DFE_7BFE980F7EAC09A1; abtest_env=product; zsxqsessionid=5fb8a1ea0dfd6a0b85851f18af6dd11e; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22218848512488441%22%2C%22first_id%22%3A%22189c524ff8572f-085944324976c38-7c546c76-2073600-189c524ff86186c%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%AB%99%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fopen.weixin.qq.com%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5YzUyNGZmODU3MmYtMDg1OTQ0MzI0OTc2YzM4LTdjNTQ2Yzc2LTIwNzM2MDAtMTg5YzUyNGZmODYxODZjIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMjE4ODQ4NTEyNDg4NDQxIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22218848512488441%22%7D%2C%22%24device_id%22%3A%22189c524ff8572f-085944324976c38-7c546c76-2073600-189c524ff86186c%22%7D");
        post.addHeader("Content-Type","application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"请稍等哦亲!\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";
        StringEntity ansEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(ansEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
