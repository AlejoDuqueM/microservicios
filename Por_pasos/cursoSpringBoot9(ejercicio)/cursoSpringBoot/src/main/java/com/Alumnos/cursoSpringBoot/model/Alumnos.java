package com.Alumnos.cursoSpringBoot.model;


public class Alumnos {

    private int id;
    private String name;
    private String email;
    private int edad;
    private String curso;

    public Alumnos() {

    }

    public Alumnos(int id, String name, String email, int edad, String curso) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.edad = edad;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
