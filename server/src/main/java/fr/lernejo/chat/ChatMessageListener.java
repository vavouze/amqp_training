package fr.lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {
    private ChatMessageRepository messageRepository;

    public ChatMessageListener(ChatMessageRepository repo){
        this.messageRepository = repo;
    }
    public void onMessage(String message){
        this.messageRepository.addChatMessage(message);
    }
}
