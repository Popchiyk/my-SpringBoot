package edu.pro.myspringboot.controller.ui;

import edu.pro.myspringboot.model.Faculty;
import edu.pro.myspringboot.model.FacultyForm;
import edu.pro.myspringboot.model.NameOfFaculty;
import edu.pro.myspringboot.service.FacultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/faculties")
public class FacultyUIController {

    static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @Autowired
    FacultyService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Faculty> facultyList = service.getAll();
        model.addAttribute("faculties", facultyList);
        return "faculties";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/ui/v1/faculties/";
    }

    @RequestMapping(value = "/page-edit/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public String pageEdit(Model model, @PathVariable String id) {
        Faculty faculty = service.getById(id);
        FacultyForm facultyForm = new FacultyForm(faculty.getId(), faculty.getName(), faculty.getNameFaculty(),
                faculty.getQuantityStudent(), faculty.getDescription());
        facultyForm.setCreatAt(faculty.getCreatAt().format(format));
        List<NameOfFaculty> names = Arrays.asList(NameOfFaculty.values());
        model.addAttribute("nameOfFaculty", names);
        model.addAttribute("editFaculty", facultyForm);
        return "editFaculty";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("editFaculty") FacultyForm facultyForm) {
        Faculty faculty = service.getById(facultyForm.getId());
        faculty.setName(facultyForm.getName());
        faculty.setNameFaculty(facultyForm.getNameFaculty());
        faculty.setDescription(facultyForm.getDescription());
        faculty.setQuantityStudent(faculty.getQuantityStudent());
        faculty.setCreatAt(LocalDateTime.parse(facultyForm.getCreatAt(), format));
        service.update(faculty);
        return "redirect:/ui/v1/faculties/";
    }

    @RequestMapping(value = "/page-add", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String pageAdd(Model model) {
        FacultyForm facultyForm = new FacultyForm();
        List<NameOfFaculty> names = Arrays.asList(NameOfFaculty.values());
        model.addAttribute("facultyForm", facultyForm);
        model.addAttribute("nameOfFaculty", names);
        return "addFaculty";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("facultyForm") FacultyForm facultyForm) {
        Faculty faculty = new Faculty(facultyForm.getName(), facultyForm.getNameFaculty(),
                facultyForm.getQuantityStudent(), facultyForm.getDescription());
        service.create(faculty);
        return "redirect:/ui/v1/faculties/";
    }

}
