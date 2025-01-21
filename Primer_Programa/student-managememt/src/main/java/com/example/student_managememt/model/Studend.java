package com.example.student_managememt.model;

public class Studend {

    private int id;

    private String name;

    private String email;

    private int age;

    private int curso;

    public Studend() {
    }

    public Studend(int id, String name, String email, int age, int curso) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
}
