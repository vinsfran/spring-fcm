package com.example.springfcm.service;

import com.example.springfcm.model.NotificationRequestModel;

/**
 * @author vinsfran
 */
public interface FcmService {

    String send(NotificationRequestModel notificationRequestModel) throws Exception;

}
