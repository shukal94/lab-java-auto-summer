package com.solvd.lab.v2.automation.classes.с15.bo;

import com.solvd.lab.v2.automation.classes.с15.adapter.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "book")
@XmlType(propOrder = { "id", "name", "author", "date" })
public class Message {
    private Long id;
    private String content;
    private String author;
    private Date date;

    public Message() {

    }

    public Message(Long id, String content, String author, Date date) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "title")
    public void setContent(String content) {
        this.content = content;
    }

    @XmlElement
    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message [" + id + " " + content + " " + date.toString() + "]";
    }
}