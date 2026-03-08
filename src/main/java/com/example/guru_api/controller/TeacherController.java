package com.example.guru_api.controller;

import com.example.guru_api.dto.ApiResponse;
import com.example.guru_api.dto.TeacherDto;
import com.example.guru_api.entity.Teacher;
import com.example.guru_api.service.TeacherService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin(origins="*")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // GET ALL
    @GetMapping
    public ApiResponse<List<Teacher>> getTeachers() {

        List<Teacher> teachers = teacherService.getAllTeachers();

        return new ApiResponse<>(
                true,
                "Data berhasil didapatkan",
                teachers
        );
    }

    // CREATE
    @PostMapping
    public ApiResponse<Teacher> createTeacher(@Valid @RequestBody TeacherDto dto) {

        Teacher teacher = teacherService.createTeacher(dto);

        return new ApiResponse<>(
                true,
                "Data guru berhasil dibuat",
                teacher
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ApiResponse<Teacher> updateTeacher(
            @PathVariable Long id,
            @Valid @RequestBody TeacherDto dto
    ) {

        Teacher teacher = teacherService.updateTeacher(id, dto);

        return new ApiResponse<>(
                true,
                "Data guru berhasil diperbarui",
                teacher
        );
    }
}