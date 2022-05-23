package edu.pro.myspringboot.controller.api;

import edu.pro.myspringboot.model.Faculty;
import edu.pro.myspringboot.service.FacultyService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/faculties/")
@PreAuthorize("hasRole('ADMIN')")
public class FacultyRestController {

    @Autowired
    FacultyService service;


    @ApiOperation(value = "Get all Faculties", notes = "View all Faculties")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/")
    public List<Faculty> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "Get by Id Faculty", notes = "View one faculty")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 404, message = "Very bad news, not found faculty"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/{id}")
    public Faculty getById(@PathVariable(value = "id") String id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Delete faculty by id", notes = "Delete faculty")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 404, message = "Very bad news, not found faculty"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create Faculty ", notes = "Create faculty")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 404, message = "We have a problem"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping("/")
    public Faculty create(@RequestBody Faculty faculty) {
        return service.create(faculty);
    }

    @ApiOperation(value = "Update Faculty", notes = "Update faculty")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Champion"),
            @ApiResponse(code = 403, message = "Access is closed"),
            @ApiResponse(code = 404, message = "Captain we have a problem"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PutMapping("/")
    public Faculty update(@RequestBody Faculty faculty) {
        return service.update(faculty);
    }

}
