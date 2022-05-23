package edu.pro.myspringboot.model;


import java.time.LocalDateTime;

public class FacultyForm {

    private String id;
    private String name;
    private NameOfFaculty nameFaculty;
    private int quantityStudent;
    private String description;
    private String creatAt;
    private String updateAt;

    public FacultyForm() {
    }

    public FacultyForm(String id, String name, NameOfFaculty nameFaculty, int quantityStudent, String description,
                       String creatAt, String updateAt) {
        this.id = id;
        this.name = name;
        this.nameFaculty = nameFaculty;
        this.quantityStudent = quantityStudent;
        this.description = description;
        this.creatAt = creatAt;
        this.updateAt = updateAt;
    }

    public FacultyForm(String id, String name, NameOfFaculty nameFaculty, int quantityStudent, String description) {
        this.id = id;
        this.name = name;
        this.nameFaculty = nameFaculty;
        this.quantityStudent = quantityStudent;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NameOfFaculty getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(NameOfFaculty nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public int getQuantityStudent() {
        return quantityStudent;
    }

    public void setQuantityStudent(int quantityStudent) {
        this.quantityStudent = quantityStudent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(String creatAt) {
        this.creatAt = creatAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
