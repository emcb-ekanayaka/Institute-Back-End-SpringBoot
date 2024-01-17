package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.TeacherDto;
import com.edu.Institiute.dto.requestDto.RequestTeacherDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.StudentResponseDto;
import com.edu.Institiute.dto.responseDto.TeacherResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseStudentDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseTeacherDto;
import com.edu.Institiute.entity.*;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.CourseRepo;
import com.edu.Institiute.repo.QualificationRepo;
import com.edu.Institiute.repo.TeacherRepo;
import com.edu.Institiute.service.TeacherService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.CourseMapper;
import com.edu.Institiute.utill.mapper.QualificationMapper;
import com.edu.Institiute.utill.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeacherRegistryImpl implements TeacherService {

    @Autowired
    private Generator generator;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private QualificationMapper qualificationMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private QualificationRepo qualificationRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public CommonResponseDto saveTeacher(RequestTeacherDto dto) {
        try {
            String teacherRegistryCode = "IBM-T" + "-" + generator.generateFourNumbers();
            String teacherId = generator.generateFourNumbers();

            Optional<Course> course = courseRepo.findCourseByName(dto.getCourse());
            Optional<Qualification> qualification = qualificationRepo.findQualificationById(dto.getQualification());

            TeacherDto teacherDto = new TeacherDto(
                    teacherId,
                    teacherRegistryCode,
                    dto.getTeacherName(),
                    courseMapper.toCourseDto(course.get()),
                    qualificationMapper.toQualificationDto(qualification.get())
            );

            teacherRepo.save(teacherMapper.dtoToTeacherEntity(teacherDto));

            return new CommonResponseDto(201, "Teacher  saved!", teacherDto.getTeacherName(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto updateTeacher(RequestTeacherDto dto, String teacherId) {
        try {

            Teacher allTeachers = teacherRepo.findByTeacherId(teacherId);
            Optional<Course> course = courseRepo.findCourseByName(dto.getCourse());
            Optional<Qualification> qualification = qualificationRepo.findQualificationById(dto.getQualification());

            allTeachers.setTeacherName(dto.getTeacherName());
            allTeachers.setCourse(course.get());
            allTeachers.setQualification(qualification.get());

            teacherRepo.save(allTeachers);

            return new CommonResponseDto(201, "Teacher  Updated!", allTeachers.getTeacherName(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto removeTeacher(String teacherId) {
        Teacher teacher = teacherRepo.findByTeacherId(teacherId);

        if (!teacher.equals(null)) {
            teacherRepo.delete(teacher);
            return new CommonResponseDto(201, "Teacher was deleted! ", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Teacher Data...!");
        }
    }

    @Override
    public PaginatedResponseTeacherDto teacherById(String teacherId) throws SQLException {
        try {
            List<Teacher> allTeachersForProvidedId = teacherRepo.getAllTeachersForProvidedId(teacherId);
            List<TeacherResponseDto> teacherResponseDto = new ArrayList<>();

            for (Teacher r : allTeachersForProvidedId) {
                teacherResponseDto.add(
                        new TeacherResponseDto(
                                r.getId(),
                                r.getTeacherCode(),
                                r.getTeacherName(),
                                courseMapper.toCourseDto(r.getCourse()),
                                qualificationMapper.toQualificationDto(r.getQualification())
                        )
                );
            }

            return new PaginatedResponseTeacherDto(
                    teacherRepo.count(),
                    teacherResponseDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }
    }

    @Override
    public PaginatedResponseTeacherDto allTeachers() throws SQLException {
        try {
            List<Teacher> allTeacherForProvidedId = teacherRepo.findAll();
            List<TeacherResponseDto> teacherResponseDto = new ArrayList<>();

            for (Teacher r : allTeacherForProvidedId) {
                teacherResponseDto.add(
                        new TeacherResponseDto(
                                r.getId(),
                                r.getTeacherCode(),
                                r.getTeacherName(),
                                courseMapper.toCourseDto(r.getCourse()),
                                qualificationMapper.toQualificationDto(r.getQualification())
                        )
                );
            }

            return new PaginatedResponseTeacherDto(
                    teacherRepo.count(),
                    teacherResponseDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }
}
