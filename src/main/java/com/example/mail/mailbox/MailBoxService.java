package com.example.mail.mailbox;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Service
public class MailBoxService {

    private final MailBoxRepository repository;

    @Autowired
    public MailBoxService(MailBoxRepository repository) {
        this.repository = repository;
    }

    public List<MailBox> getMailsList() {
        return repository.findAll();
    }

    public MailBox getMail(Long mailId) {
        return repository.findById(mailId)
                .orElseThrow(() -> new IllegalStateException("mail with ID" + mailId + " is not found"));
    }

    // public EntityModel<MailBox> getMails(Long mailId) {
    // // MailBox mail = repository.findById(mailId).get();
    // // .orElseThrow(() -> new IllegalStateException("mail with ID" + mailId + "
    // is
    // // not found"));

    // return repository.findById(mailId).map(mail -> EntityModel.of(mail,
    // linkTo(methodOn(MailBoxRepository.class).findById(mail.getId())).withSelfRel(),
    // linkTo(methodOn(MailBoxRepository.class).findAll()).withRel("mails")))
    // .orElseThrow(() -> new IllegalStateException("mail with ID" + mailId + " is
    // not found"));

    // }

    public MailBox addMail(MailBox mail) {
        return repository.save(mail);

    }

    public String removeMail(Long mailId) {
        repository.deleteById(mailId);
        return "Mail deleted";
    }

    public MailBox updateMail(Long mailId, MailBox newMail) {
        return repository.findById(mailId)
                .map(mail -> {
                    mail.setTitle(newMail.getTitle());
                    mail.setMessage(newMail.getMessage());
                    mail.setAuthor(newMail.getAuthor());
                    return repository.save(mail);
                })
                .orElseThrow(() -> new IllegalStateException("Mail with id " + mailId + " doesn't exist"));

    }
}