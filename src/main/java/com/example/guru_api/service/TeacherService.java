package com.example.guru_api.service;

import com.example.guru_api.dto.TeacherDto;
import com.example.guru_api.entity.Teacher;
import com.example.guru_api.entity.User;
import com.example.guru_api.repository.TeacherRepository;
import com.example.guru_api.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;

    public TeacherService(TeacherRepository teacherRepository, UserRepository userRepository) {
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }

    // READ → menampilkan semua data guru
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // CREATE → menambahkan guru baru dengan relasi ke user yang login
    public Teacher createTeacher(TeacherDto dto) {
        Teacher teacher = new Teacher();

        teacher.setName(dto.getName());
        teacher.setSubject(dto.getSubject());
        teacher.setStatus(dto.getStatus());

        // Ambil username dari context security (user yang sedang login)
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        // Cari user di database
        User currentUser = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new RuntimeException("User login tidak ditemukan"));

        // Set relasi database (Mapping)
        teacher.setUser(currentUser);

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