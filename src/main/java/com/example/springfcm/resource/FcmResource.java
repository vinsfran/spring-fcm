package com.example.springfcm.resource;

import com.example.springfcm.model.NotificationRequestModel;
import com.example.springfcm.service.FcmService;
import io.swagger.annotations.Api;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/fcm")
public class FcmResource {

    private static final Log LOG = LogFactory.getLog(FcmResource.class);

    @Autowired
    @Qualifier("fcmServiceImpl")
    private FcmService fcmService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registarAuditoriaPrint(@Valid @RequestBody NotificationRequestModel notificationRequestModel) {


        try {
            String body = fcmService.send(notificationRequestModel);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
