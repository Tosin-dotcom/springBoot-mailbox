package com.example.mail.mailbox;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "api/v1/mail")
public class MailBoxController {

    private final MailBoxService mailBoxService;

    @Autowired
    public MailBoxController(MailBoxService mailBoxService) {
        this.mailBoxService = mailBoxService;
    }

    @GetMapping()
    public List<MailBox> getMail() {
        return mailBoxService.getMailsList();
    }

    @GetMapping(path = "{mailId}")
    public MailBox getMailBox(@PathVariable Long mailId) {
        return mailBoxService.getMail(mailId);
    }

    @PostMapping()
    public MailBox addMail(@RequestBody MailBox mail) {
        return mailBoxService.addMail(mail);
    }

    @DeleteMapping(path = "{mailId}")
    public String deleteMail(@PathVariable Long mailId) {
        return mailBoxService.removeMail(mailId);
    }

    @PutMapping(path = "{mailId}")
    public MailBox updateMail(@PathVariable Long mailId, @RequestBody MailBox mail) {
        return mailBoxService.updateMail(mailId, mail);
    }

}
