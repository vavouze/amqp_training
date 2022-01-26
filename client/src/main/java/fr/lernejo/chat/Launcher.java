package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) throws IOException {
        System.out.println("Input a message,we will print it for you (q for quit)");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate template = context.getBean(RabbitTemplate.class);
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        while (!message.equals("q")){
            //add to repo
            template.convertAndSend("","chat_messages",message);
            System.out.println("message sent,Input a message,we will print it for you (q for quit)");
            message = scanner.nextLine();
        }
        return;
    }
}
