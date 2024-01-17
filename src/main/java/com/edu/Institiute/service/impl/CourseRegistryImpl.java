package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.CourseDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.CourseResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseCourseDto;
import com.edu.Institiute.entity.Course;
import com.edu.Institiute.entity.StudentHasCourse;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.CourseRepo;
import com.edu.Institiute.repo.StudentHasCourseRepo;
import com.edu.Institiute.service.CourseService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseRegistryImpl implements CourseService {

    @Autowired
    private Generator generator;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentHasCourseRepo studentHasCourseRepo;

    @Override
    public CommonResponseDto saveCourse(RequestRegistryDto dto) {
        try {
            String courseRegistryCode = "IBM-C" + "-" + generator.generateFourNumbers();
            String courseId =  generator.generateFourNumbers();

            CourseDto courseDto = new CourseDto(
                    courseId,
                    courseRegistryCode,
                    dto.getCourseName()

            );
            courseRepo.save(courseMapper.dtoToCourseEntity(courseDto));

            return new CommonResponseDto(201, "Course  saved!", courseDto.getCourseName(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto updateCourse(RequestRegistryDto dto, String courseId) {
        try {

            Course allCourseForProvidedId = courseRepo.getAllCourseForProvidedId(courseId);
            allCourseForProvidedId.setCourseCode(dto.getCourseCode());
            allCourseForProvidedId.setCourseName(dto.getCourseName());

            courseRepo.save(allCourseForProvidedId);
            return new CommonResponseDto(201, "Course  Updated!", allCourseForProvidedId.getCourseCode(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto removeCourse(String courseId) {
        Optional<Course> course = courseRepo.getCourseById(courseId);
        List<StudentHasCourse> studentHasCourses = studentHasCourseRepo.getStudentAndCourse(courseId);

        if (!studentHasCourses.isEmpty()){
            for (StudentHasCourse r : studentHasCourses){
                studentHasCourseRepo.deleteById(r.getId());
            }
        }

        if (course.isPresent()) {
            courseRepo.delete(course.get());
            return new CommonResponseDto(201, "Course was deleted!", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Student...!");
        }
    }

    @Override
    public PaginatedResponseCourseDto courseById(String courseCode) throws SQLException {
        try {
            List<Course> allCourseForProvidedId = courseRepo.getAllCourse(courseCode);
            List<CourseResponseDto> courseResponseDto = new ArrayList<>();

            for (Course r : allCourseForProvidedId) {
                courseResponseDto.add(
                        new CourseResponseDto(
                                r.getId(),
                                r.getCourseCode(),
                                r.getCourseName()
                        )
                );
            }
            System.out.println(courseResponseDto);
            return new PaginatedResponseCourseDto(
                    courseRepo.countAllStudentForProvidedId(courseCode),
                    courseResponseDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }
    }

    @Override
    public PaginatedResponseCourseDto allCourse() throws SQLException {
        try {
            List<Course> allCourseForProvidedId = courseRepo.findAll();
            List<CourseResponseDto> courseResponseDos = new ArrayList<>();

            for (Course r : allCourseForProvidedId) {
                courseResponseDos.add(
                        new CourseResponseDto(
                                r.getId(),
                                r.getCourseCode(),
                                r.getCourseName()
                        )
                );
            }
            return new PaginatedResponseCourseDto(
                    courseRepo.count(),
                    courseResponseDos
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }


}
