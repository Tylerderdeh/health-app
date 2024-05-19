package kz.iitu.healthapp.repository;

import kz.iitu.healthapp.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findBySenderIdAndRecipientIdOrSenderIdAndRecipientIdOrderByTimestamp(Long senderId, Long recipientId, Long recipientId1, Long senderId1);

}
