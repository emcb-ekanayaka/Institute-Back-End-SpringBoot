package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.StudentDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.StudentResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseStudentDto;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.entity.Student;
import com.edu.Institiute.entity.StudentHasCourse;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.repo.StudentHasCourseRepo;
import com.edu.Institiute.repo.StudentRepo;
import com.edu.Institiute.service.StudentService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.StatusMapper;
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
public class StudentRegistryImpl implements StudentService {
    private final Generator generator;

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentHasCourseRepo studentHasCourseRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private StudentMapper studentMapper;

    public StudentRegistryImpl(Generator generator) {
        this.generator = generator;
    }

    @Override
    public CommonResponseDto saveStudent(RequestRegistryDto dto) {
        try {
            String studentRegistryCode = "IBM-S" + "-" + generator.generateFourNumbers();
            String studentId =  generator.generateFourNumbers();
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());

            StudentDto studentDto = new StudentDto(
                    studentId,
                    studentRegistryCode,
                    dto.getStudentName(),
                    dto.getStudentAge(),
                    dto.getStudentNic(),
                    statusMapper.toStatusDto(status.get())
            );
            studentRepo.save(studentMapper.dtoToStudentEntity(studentDto));

            return new CommonResponseDto(201, "Student  saved!", studentDto.getStudentCode(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto updateStudent(RequestRegistryDto dto, String studentId) {
        try {

            Student allStudentForProvidedId = studentRepo.findByStudentId(studentId);
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());

                        allStudentForProvidedId.setStudentCode(dto.getStudentCode());
                        allStudentForProvidedId.setStudentName(dto.getStudentName());
                        allStudentForProvidedId.setStudentAge(dto.getStudentAge());
                        allStudentForProvidedId.setStudentNic(dto.getStudentNic());
                        allStudentForProvidedId.setStatus(status.get());

            studentRepo.save(allStudentForProvidedId);

            return new CommonResponseDto(201, "Student  Updated!", allStudentForProvidedId.getStudentName(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto removeStudent(String studentId) {

        Optional<Student> student = studentRepo.getStudentById(studentId);
        List<StudentHasCourse> studentHasCourses = studentHasCourseRepo.getStudentAndCourse(studentId);

        if(!studentHasCourses.isEmpty()){
            for(StudentHasCourse r : studentHasCourses){
                studentHasCourseRepo.deleteById(r.getId());
            }
        }

        if (student.isPresent()) {
            studentRepo.delete(student.get());
            return new CommonResponseDto(201, "Student was deleted! ", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Student...!");
        }
    }

    @Override
    public PaginatedResponseStudentDto studentById(String studentCode) {
        try {
            List<Student> allStudentForProvidedId = studentRepo.getAllStudentForProvidedId(studentCode);
            System.out.println();
            List<StudentResponseDto> studentResponseDos = new ArrayList<>();

            for (Student r : allStudentForProvidedId) {
                studentResponseDos.add(
                        new StudentResponseDto(
                                r.getId(),
                                r.getStudentCode(),
                                r.getStudentName(),
                                r.getStudentAge(),
                                r.getStudentNic(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }

            return new PaginatedResponseStudentDto(
                    studentRepo.countAllStudentForProvidedId(studentCode),
                    studentResponseDos
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }
    }

    @Override
    public PaginatedResponseStudentDto allStudent() {
        try {
            List<Student> allStudentForProvidedId = studentRepo.findAll();
            List<StudentResponseDto> studentResponseDos = new ArrayList<>();

            for (Student r : allStudentForProvidedId) {
                studentResponseDos.add(
                        new StudentResponseDto(
                                r.getId(),
                                r.getStudentCode(),
                                r.getStudentName(),
                                r.getStudentAge(),
                                r.getStudentNic(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }

            return new PaginatedResponseStudentDto(
                    studentRepo.count(),
                    studentResponseDos
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }

    @Override
    public PaginatedResponseStudentDto allStudentForClass(String courseCode) throws SQLException {
        try {
            System.out.println(courseCode);
            List<Student> allStudentForClass = studentRepo.findByStudentIdForClass(courseCode);
            System.out.println(allStudentForClass);
            List<StudentResponseDto> studentResponseForClass = new ArrayList<>();

            for (Student r : allStudentForClass) {
                studentResponseForClass.add(
                        new StudentResponseDto(
                                r.getId(),
                                r.getStudentCode(),
                                r.getStudentName(),
                                r.getStudentAge(),
                                r.getStudentNic(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }

            return new PaginatedResponseStudentDto(
                    studentRepo.count(),
                    studentResponseForClass
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }


}
