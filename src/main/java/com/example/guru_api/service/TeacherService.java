package com.example.guru_api.service;

import com.example.guru_api.dto.TeacherDto;
import com.example.guru_api.entity.Teacher;
import com.example.guru_api.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    // READ → menampilkan semua data guru
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // CREATE → menambahkan guru baru
    public Teacher createTeacher(TeacherDto dto) {
        Teacher teacher = new Teacher();

        teacher.setName(dto.getName());
        teacher.setSubject(dto.getSubject());
        teacher.setStatus(dto.getStatus());

        return teacherRepository.save(teacher);
    }

    // UPDATE → mengubah data guru termasuk status
    public Teacher updateTeacher(Long id, TeacherDto dto) {

        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guru tidak ditemukan"));

        teacher.setName(dto.getName());
        teacher.setSubject(dto.getSubject());
        teacher.setStatus(dto.getStatus());

        return teacherRepository.save(teacher);
    }
}