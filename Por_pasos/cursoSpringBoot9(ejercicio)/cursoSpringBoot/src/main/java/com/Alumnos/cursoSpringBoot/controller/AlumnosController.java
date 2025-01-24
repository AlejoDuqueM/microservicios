package com.Alumnos.cursoSpringBoot.controller;

import com.Alumnos.cursoSpringBoot.model.Alumnos;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnosController {

    private List<Alumnos> alumnos = new ArrayList<>(Arrays.asList(
            new Alumnos(1, "Juan", "juan@email.com", 20, "Once"),
            new Alumnos(2, "Alejandro", "alejo@mail.com", 14, "Septimo"),
            new Alumnos(3, "Maria", "maria@mail.com", 18, "Noveno"),
            new Alumnos(4, "Jose", "jose@mail.com", 16, "Octavo"))
    );

    @GetMapping
    public List<Alumnos> getAllAlumnos() {

        return alumnos;

    }

    @GetMapping(value = "/{email}")
    public Alumnos getAlumnoByEmail(@PathVariable String email) {

        for(Alumnos a : alumnos) {

            if(a.getEmail().equalsIgnoreCase(email)) {

                return a;

            }

        }

        return null;

    }

    @PostMapping
    public Alumnos postAlumno(@RequestBody Alumnos alumno) {

        alumnos.add(alumno);

        return alumno;

    }

    @PutMapping
    public Alumnos putAlumno(@RequestBody Alumnos alumnoPut) {

        for (Alumnos a: alumnos) {

            if (a.getId() == alumnoPut.getId()) {

                a.setName(alumnoPut.getName());
                a.setEmail(alumnoPut.getEmail());
                a.setEdad(alumnoPut.getEdad());
                a.setCurso(alumnoPut.getCurso());

                return a;

            }

        }

        return null;

    }

    @PatchMapping
    public Alumnos patchAlumno(@RequestBody Alumnos alumnoPatch) {

        for (Alumnos a: alumnos) {

            if (a.getId() == alumnoPatch.getId()) {

                if(alumnoPatch.getName() != null) {

                    a.setName(alumnoPatch.getName());

                }

                if(alumnoPatch.getEmail() != null) {

                    a.setEmail(alumnoPatch.getEmail());

                }

                if(alumnoPatch.getEdad() != 0) {

                    a.setEdad(alumnoPatch.getEdad());

                }

                if(alumnoPatch.getCurso() != null) {

                    a.setCurso(alumnoPatch.getCurso());

                }

                return a;

            }

        }

        return null;

    }

    @DeleteMapping(value = "/{id}")
    public Alumnos deleteAlumno(@PathVariable int id) {

        for (Alumnos a: alumnos) {

            if (a.getId() == id) {

                alumnos.remove(a);

                return a;

            }

        }

        return null;

    }


}

