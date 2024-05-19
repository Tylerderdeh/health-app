package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.dto.MessageRequest;
import kz.iitu.healthapp.entity.Message;
import kz.iitu.healthapp.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/send")
    @SendTo("/topic/greetings")
    public String sendMessage(@RequestBody MessageRequest message) {
        // Validate message content and sender/recipient IDs if needed

        messageService.sendMessage(message);
        return "Message sent successfully";
    }

//    @GetMapping("/history/{senderId}/{recipientId}")
//    public ResponseEntity<?> getMessageHistory(
//            @PathVariable Long senderId,
//            @PathVariable Long recipientId
//    ) {
//        List<Message> messages = messageService.getMessagesBetweenUsers(senderId, recipientId);
//        return ResponseEntity.ok(messages);
//    }
}