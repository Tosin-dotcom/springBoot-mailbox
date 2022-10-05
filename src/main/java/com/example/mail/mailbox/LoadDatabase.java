package com.example.mail.mailbox;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner commandLineRunner(MailBoxRepository repository) {
        return args -> {
            MailBox mail = new MailBox("title one", "body of mail", "Tosin");
            MailBox anotherMail = new MailBox("title two", "body of mail two", "Jerry");

            repository.saveAll(
                    List.of(mail, anotherMail));
        };
    }
}
