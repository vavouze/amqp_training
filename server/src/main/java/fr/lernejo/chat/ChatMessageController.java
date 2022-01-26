package fr.lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatMessageController {

    private ChatMessageRepository messageRepository;

    public ChatMessageController(ChatMessageRepository repoMessage){
        this.messageRepository = repoMessage;
    }

    @GetMapping("api/message")
    public Iterable<String> get(){
        return this.messageRepository.getLastTenMessages();
    }
}
