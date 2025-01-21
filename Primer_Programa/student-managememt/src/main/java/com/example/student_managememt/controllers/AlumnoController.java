package com.example.student_managememt.controllers;

import com.example.student_managememt.model.Studend;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private List<Studend> alumnos = new ArrayList<>(Arrays.asList(

            new Studend(1, "Juan Perez", "juan@email.com", 20, 1),
            new Studend(2, "Alejandro Duque", "alejomudu@email.com", 35, 4),
            new Studend(3, "Catalina Pacheco", "ktik@email.com", 35, 4),
            new Studend(4, "Luisa Perez", "luisa@email.com", 20, 1)

    ));


    @GetMapping
    public List<Studend> getAllAlumnos() {

        return alumnos;

    }

    @GetMapping("/{email}")
    public Studend getAlumno(@PathVariable String email) {

        for (Studend a : alumnos) {

            if (a.getEmail().equalsIgnoreCase(email)) {

                return a;

            }

        }

        return null;
    }

    @PostMapping
    public Studend postAlumno(@RequestBody Studend alumno) {

        alumnos.add(alumno);

        return alumno;

    }

    @PatchMapping
    public Studend patchAlumno(@RequestBody Studend alumno) {

        for (Studend a : alumnos) {

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

    @PutMapping
    public Studend putAlumno(@RequestBody Studend alumno){

        for (Studend a : alumnos) {

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
    public Studend borarAlumno(@PathVariable int id) {

        for (Studend a : alumnos) {

            if (a.getId() == id) {

                alumnos.remove(a);

                return a;

            }

        }

        return null;

    }



}
