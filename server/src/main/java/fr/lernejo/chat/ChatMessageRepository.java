package fr.lernejo.chat;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatMessageRepository {
    private ArrayList<String> message = new ArrayList<>();

    public void addChatMessage(String message){
        if (this.message.size() == 10){
            this.message.remove(0);
        }
        this.message.add(message);
    }
    public List<String> getLastTenMessages(){
        return this.message.subList(Math.max(this.message.size() - 10, 0), this.message.size());
    }
}
