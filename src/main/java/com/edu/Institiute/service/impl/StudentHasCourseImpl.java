package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.StudentHasCourseDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.StudentHasCourseResponseDto;
import com.edu.Institiute.dto.responseDto.StudentResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseStudentDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseStudentHasCourseDto;
import com.edu.Institiute.entity.Course;
import com.edu.Institiute.entity.Student;
import com.edu.Institiute.entity.StudentHasCourse;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.CourseRepo;
import com.edu.Institiute.repo.StudentHasCourseRepo;
import com.edu.Institiute.repo.StudentRepo;
import com.edu.Institiute.service.StudentHasCourseService;
import com.edu.Institiute.utill.mapper.CourseMapper;
import com.edu.Institiute.utill.mapper.StudentHasCourseMapper;
import com.edu.Institiute.utill.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentHasCourseImpl implements StudentHasCourseService {

    @Autowired
    private StudentHasCourseMapper studentHasCourseMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentHasCourseRepo studentHasCourseRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public CommonResponseDto saveStudentHasCourse(RequestRegistryDto dto) {

        Optional<Student> student = studentRepo.findStudentByName(dto.getStudentName());
        Optional<Course> course = courseRepo.findCourseByName(dto.getCourseName());


        if (student.isPresent() && course.isPresent()){

            try {
                StudentHasCourseDto studentHasCourseDto = new StudentHasCourseDto(
                        studentMapper.toStudentDto(student.get()),
                        courseMapper.toCourseDto(course.get())
                );
                System.out.println("This is the main Object ------- >>> "+studentHasCourseDto);
                studentHasCourseRepo.save(studentHasCourseMapper.dtoToStudentHasCourseEntity(studentHasCourseDto));

                return new CommonResponseDto(201, "Student - Course  saved!", studentHasCourseDto, new ArrayList<>());
            }catch (Exception e){
                throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
            }

        }else {
            return new CommonResponseDto(400, "Student - Course  Not Found!",0, new ArrayList<>());
        }
    }

    @Override
    public CommonResponseDto updateStudentHasCourse(RequestRegistryDto dto, Integer studentHasCourseId) {
        try {

            StudentHasCourse allStudentHasCourse = studentHasCourseRepo.findByStudentHasCourse(studentHasCourseId);
            Optional<Student> student = studentRepo.findStudentByName(dto.getStudentName());
            Optional<Course> course = courseRepo.findCourseByName(dto.getCourseName());

            allStudentHasCourse.setStudentId(student.get());
            allStudentHasCourse.setCourseId(course.get());

            System.out.println("Object ------------>>>>> "+allStudentHasCourse);
            studentHasCourseRepo.save(allStudentHasCourse);

            return new CommonResponseDto(201, "Student- Course Updated!", allStudentHasCourse.getId(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto removeStudentHasCourse(Integer studentHasCourseId) {

        Optional<StudentHasCourse> allStudentHasCourse = studentHasCourseRepo.findById(studentHasCourseId);

        if (allStudentHasCourse.isPresent()) {
            studentHasCourseRepo.delete(allStudentHasCourse.get());
            return new CommonResponseDto(201, "Student - Course was deleted! ", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Student - Course...!");
        }
    }

    @Override
    public PaginatedResponseStudentHasCourseDto studentHasCourseById(Integer studentHasCourseId) throws SQLException {
        try {
            List<StudentHasCourse> studentHasCoursesList = studentHasCourseRepo.getAllStudentCourse(studentHasCourseId);
            List<StudentHasCourseResponseDto> studentHasCourseListDto = new ArrayList<>();

            for (StudentHasCourse r : studentHasCoursesList) {
                studentHasCourseListDto.add(
                        new StudentHasCourseResponseDto(
                                r.getId(),
                                studentMapper.toStudentDto(r.getStudentId()),
                                courseMapper.toCourseDto(r.getCourseId())
                        )
                );
            }
            return new PaginatedResponseStudentHasCourseDto(
                    studentHasCourseRepo.count(),
                    studentHasCourseListDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }
    }

    @Override
    public PaginatedResponseStudentHasCourseDto allStudentHasCourse() throws SQLException {
        try {
            List<StudentHasCourse> allStudentHasCourses = studentHasCourseRepo.findAll();
            List<StudentHasCourseResponseDto> studentHasCourseResponseDTO = new ArrayList<>();

            for (StudentHasCourse r : allStudentHasCourses) {
                studentHasCourseResponseDTO.add(
                        new StudentHasCourseResponseDto(
                                r.getId(),
                                studentMapper.toStudentDto(r.getStudentId()),
                                courseMapper.toCourseDto(r.getCourseId())
                        )
                );
            }

            return new PaginatedResponseStudentHasCourseDto(
                    studentHasCourseRepo.count(),
                    studentHasCourseResponseDTO
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }

    @Override
    public PaginatedResponseStudentHasCourseDto allStudentHasCourseForClass(String studentId, String courseId) throws SQLException {
        try {
            List<StudentHasCourse> allStudentHasCoursesForClass = studentHasCourseRepo.getAllStudentHasCourse(studentId,courseId);
            List<StudentHasCourseResponseDto> studentHasCourseResponseClassDTO = new ArrayList<>();

            for (StudentHasCourse r : allStudentHasCoursesForClass) {
                studentHasCourseResponseClassDTO.add(
                        new StudentHasCourseResponseDto(
                                r.getId(),
                                studentMapper.toStudentDto(r.getStudentId()),
                                courseMapper.toCourseDto(r.getCourseId())
                        )
                );
            }

            return new PaginatedResponseStudentHasCourseDto(
                    studentHasCourseRepo.count(),
                    studentHasCourseResponseClassDTO
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }

}
