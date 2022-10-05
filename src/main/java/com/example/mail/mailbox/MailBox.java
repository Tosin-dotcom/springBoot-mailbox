package com.example.mail.mailbox;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class MailBox {
    private @Id @GeneratedValue Long id;
    private String title;
    private String message;
    private String author;

    @Transient
    private LocalDate dateAdded;

    public MailBox() {
    }

    public MailBox(String title, String message, String author) {
        this.title = title;
        this.message = message;
        this.author = author;
        // this.dateAdded = dateAdded;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDateAdded() {
        return LocalDate.now();
        // return this.dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public MailBox id(Long id) {
        setId(id);
        return this;
    }

    public MailBox title(String title) {
        setTitle(title);
        return this;
    }

    public MailBox message(String message) {
        setMessage(message);
        return this;
    }

    public MailBox author(String author) {
        setAuthor(author);
        return this;
    }

    public MailBox dateAdded(LocalDate dateAdded) {
        setDateAdded(dateAdded);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MailBox)) {
            return false;
        }
        MailBox mailBox = (MailBox) o;
        return Objects.equals(id, mailBox.id) && Objects.equals(title, mailBox.title)
                && Objects.equals(message, mailBox.message) && Objects.equals(author, mailBox.author)
                && Objects.equals(dateAdded, mailBox.dateAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, message, author, dateAdded);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", title='" + getTitle() + "'" +
                ", message='" + getMessage() + "'" +
                ", author='" + getAuthor() + "'" +
                ", dateAdded='" + getDateAdded() + "'" +
                "}";
    }
}