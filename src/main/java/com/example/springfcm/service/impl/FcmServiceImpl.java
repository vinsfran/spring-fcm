package com.example.springfcm.service.impl;

import com.example.springfcm.model.NotificationRequestModel;
import com.example.springfcm.service.FcmService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

/**
 * @author vinsfran
 */
@Service("fcmServiceImpl")
public class FcmServiceImpl implements FcmService {

    private static final Log LOG = LogFactory.getLog(FcmServiceImpl.class);

    @Value("${url.fcm.send}")
    private String urlFcmSend;

    @Value("${fcm.key}")
    private String key;

    @Override
    public String send(NotificationRequestModel notificationRequestModel) throws Exception {
        String body = null;
        HttpResponse<JsonNode> response;
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<NotificationRequestModel>() {
            }.getType();

            String json = gson.toJson(notificationRequestModel, type);

            StringEntity input = new StringEntity(json);
            input.setContentType("application/json");


            LOG.info("ENTRO1");
            response = Unirest.post(urlFcmSend)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "key=" + key)
                    .body(json)
                    .asJson();
            if (response.getStatus() == 200) {
                body = response.getBody().toString();
            } else {
                throw new Exception("Error code: " + response.getStatus());
            }
        } catch (UnirestException ex) {
            LOG.info("ENTRO2");
            throw new Exception(ex.getMessage());
        }
        return body;
    }

}
