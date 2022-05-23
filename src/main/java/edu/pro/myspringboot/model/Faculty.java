package edu.pro.myspringboot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@ApiModel
@Document
public class Faculty {
    @Id
    @ApiModelProperty(value = " UUID is given by DB", required = true, dataType = "UUID to String",
            example = "For Example")
    private String id;
    @Schema(description = "FIO", example = "Popiuk Roman Arturovuch")
    private String name;
    @Schema(description = "Name faculty")
    private NameOfFaculty nameFaculty;
    @Schema(description = "Quantity student studies at faculty")
    private int quantityStudent;
    @Schema(description = "Note")
    private String description;
    @Schema(description = "Creat faculty")
    private LocalDateTime creatAt;
    @Schema(description = "Update faculty")
    private LocalDateTime updateAt;

    public Faculty() {
    }

    public Faculty(String name, NameOfFaculty nameFaculty, int quantityStudent, String description,
                   LocalDateTime creatAt, LocalDateTime updateAt) {
        this.name = name;
        this.nameFaculty = nameFaculty;
        this.quantityStudent = quantityStudent;
        this.description = description;
        this.creatAt = creatAt;
        this.updateAt = updateAt;
    }

    public Faculty(String id, String name, NameOfFaculty nameFaculty, int quantityStudent,
                   String description, LocalDateTime creatAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.nameFaculty = nameFaculty;
        this.quantityStudent = quantityStudent;
        this.description = description;
        this.creatAt = creatAt;
        this.updateAt = updateAt;
    }

    public Faculty(String name, NameOfFaculty nameFaculty, int quantityStudent,
                   String description) {
        this.name = name;
        this.nameFaculty = nameFaculty;
        this.quantityStudent = quantityStudent;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDateTime creatAt) {
        this.creatAt = creatAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return getId().equals(faculty.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nameSpeciality='" + nameFaculty + '\'' +
                ", quantityStudent=" + quantityStudent +
                ", description='" + description + '\'' +
                ", creatAt=" + creatAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
