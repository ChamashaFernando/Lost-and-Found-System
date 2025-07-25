//package lk.chamasha.lost.and.found.service.impl;
//
//import lk.chamasha.lost.and.found.controller.response.NotificationResponse;
//import lk.chamasha.lost.and.found.model.Notification;
//import lk.chamasha.lost.and.found.repository.NotificationRepository;
//import lk.chamasha.lost.and.found.service.NotificationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class NotificationServiceImpl implements NotificationService {
//
//    private final NotificationRepository notificationRepository;
//
//    @Override
//    public List<NotificationResponse> getUserNotifications(Long userId) {
//        return notificationRepository.findByUserId(userId).stream()
//                .map(this::mapToResponse)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void markAsRead(Long id) {
//        Notification notification = notificationRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Notification not found"));
//        notification.setRead(true);
//        notificationRepository.save(notification);
//    }
//
//    private NotificationResponse mapToResponse(Notification notification) {
//        return new NotificationResponse(notification.getId(), notification.getMessage(),
//                notification.getUser().getId(), notification.isRead());
//    }
//}
