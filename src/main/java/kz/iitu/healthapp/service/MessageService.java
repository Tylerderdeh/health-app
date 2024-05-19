package kz.iitu.healthapp.service;

import kz.iitu.healthapp.dto.MessageRequest;
import kz.iitu.healthapp.entity.Message;
import kz.iitu.healthapp.entity.User;
import kz.iitu.healthapp.repository.MessageRepository;
import kz.iitu.healthapp.repository.UserRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageRepository messageRepository;
    private final UserRepository userService;

    public MessageService(SimpMessagingTemplate messagingTemplate, MessageRepository messageRepository, UserRepository userService) {
        this.messagingTemplate = messagingTemplate;
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public void sendMessage(MessageRequest messageRequest) {
        User sender = userService.findById(messageRequest.getSenderId()).orElseThrow();
        User recipient = userService.findById(messageRequest.getRecipientId()).orElseThrow();
        Message message = Message
                .builder()
                .sender(sender)
                .recipient(recipient)
                .content(messageRequest.getContent())
                .timestamp(LocalDateTime.now())
                .build();
        // Save the message to the database
        messageRepository.save(message);

        // Send the message to the recipient
        messagingTemplate.convertAndSendToUser(
                String.valueOf(message.getRecipient().getId()),
                "/queue/messages",
                message
        );
    }

    public List<Message> getMessagesBetweenUsers(Long senderId, Long recipientId) {
        return messageRepository.findBySenderIdAndRecipientIdOrSenderIdAndRecipientIdOrderByTimestamp(
                senderId, recipientId, recipientId, senderId
        );
    }
}