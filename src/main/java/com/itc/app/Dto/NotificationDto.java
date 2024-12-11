package com.itc.app.Dto;

import java.time.LocalDateTime;

public class NotificationDto {
    private Long orderId;
    private String message;
    private LocalDateTime timestamp;
    private String status;

    // Constructors
    public NotificationDto() {}

    public NotificationDto(Long orderId, String message, String status) {
        this.orderId = orderId;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}