package com.example.student_managememt.controllers;

import com.example.student_managememt.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private List<Student> alumnos = new ArrayList<>(Arrays.asList(

            new Student(1, "Juan Perez", "juan@email.com", 20, 1),
            new Student(2, "Alejandro Duque", "alejomudu@email.com", 35, 4),
            new Student(3, "Catalina Pacheco", "ktik@email.com", 35, 4),
            new Student(4, "Luisa Perez", "luisa@email.com", 20, 1)

    ));


    @GetMapping
    public List<Student> getAllAlumnos() {

        return alumnos;

    }

    @GetMapping("/{email}")
    public Student getAlumno(@PathVariable String email) {

        for (Student a : alumnos) {

            if (a.getEmail().equalsIgnoreCase(email)) {

                return a;

            }

        }

        return null;
    }

    @PostMapping
    public Student postAlumno(@RequestBody Student alumno) {

        alumnos.add(alumno);

        return alumno;

    }

    @PatchMapping
    public Student patchAlumno(@RequestBody Student alumno) {

        for (Student a : alumnos) {

            if (a.getId() == alumno.getId()) {

                if(alumno.getName() != null) {

                    a.setName(alumno.getName());

                }

                if (alumno.getEmail() != null) {

                    a.setEmail(alumno.getEmail());

                }

                if (alumno.getAge() != 0) {

                    a.setAge(alumno.getAge());

                }

                if (alumno.getCurso() != 0) {

                        a.setCurso(alumno.getCurso());
                }

                return a;

            }

        }

        return null;

    }

    @PutMapping
    public Student putAlumno(@RequestBody Student alumno){

        for (Student a : alumnos) {

            if (a.getId() == alumno.getId()) {

                a.setName(alumno.getName());
                a.setEmail(alumno.getEmail());
                a.setAge(alumno.getAge());
                a.setCurso(alumno.getCurso());

                return a;

            }

        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Student borarAlumno(@PathVariable int id) {

        for (Student a : alumnos) {

            if (a.getId() == id) {

                alumnos.remove(a);

                return a;

            }

        }

        return null;

    }



}
