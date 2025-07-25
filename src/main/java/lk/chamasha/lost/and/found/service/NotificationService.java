package lk.chamasha.lost.and.found.service;

import lk.chamasha.lost.and.found.controller.response.NotificationResponse;

import java.util.List;

public interface NotificationService {
    List<NotificationResponse> getUserNotifications(Long userId);
    void markAsRead(Long id);
}
