package com.example.guru_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers") // tabel guru
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // namaA   guru
    private String name;

    // mata pelajaran
    private String subject;

    // status aktif / non aktif
    private Boolean status;

    // relasi ke tabel user (admin yang membuat data)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}