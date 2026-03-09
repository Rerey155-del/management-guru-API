package com.example.guru_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TeacherDto {
    @NotBlank(message = "Nama guru wajib diisi")
    private String name;
    
    @NotBlank(message = "Mata Pelajaran wajib diisi")
    private String subject;

    @NotNull(message = "Status wajib diisi")
    private Boolean status;

    public String getName(){
        return name;
    }

    public String getSubject(){
        return subject;
    }

    public Boolean getStatus(){
        return status;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }
}
