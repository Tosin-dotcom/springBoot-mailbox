package com.example.mail.mailbox;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Repository;

@Repository
public interface MailBoxRepository extends JpaRepository<MailBox, Long> {
    // public MailBox e
    // public class MailBox extends RepresentationModel<MailBox>;

}
