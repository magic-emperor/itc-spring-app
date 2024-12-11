package com.itc.app.productServiceImplemets;

import com.itc.app.Dto.NotificationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public NotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendNotification(NotificationDto notification) {
        try {
            logger.info("Sending notification: {}", notification.getMessage());
            messagingTemplate.convertAndSend("/topic/products", notification);
            logger.info("Notification sent successfully");
        } catch (Exception e) {
            logger.error("Error sending notification: {}", e.getMessage());
            throw e;
        }
    }
}