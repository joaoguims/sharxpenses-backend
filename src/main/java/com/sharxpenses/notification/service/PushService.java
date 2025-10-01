package com.sharxpenses.notification.service;

import org.springframework.stereotype.Service;

@Service
public class PushService {

    public void sendPush(String userId, String title, String body) {
        // TODO: integrar Firebase Cloud Messaging (FCM)
        System.out.println("Push enviado para usuário " + userId + ": " + title + " - " + body);
    }
}
