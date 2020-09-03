package com.example.ppmtool.web;

import com.example.ppmtool.domain.Chand;
import com.example.ppmtool.domain.Project;
import com.example.ppmtool.repositories.ProjectRepository;
import com.example.ppmtool.services.ChandService;
import com.example.ppmtool.services.MapValidationErrorService;
import com.example.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private ChandService chandService;

    @PostMapping("/project")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result)
    {

            ResponseEntity<?> errorMap =mapValidationErrorService.MapValidationError(result);
            if(errorMap!=null)
                return errorMap;
        projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId)
    {
        Project project= projectService.findProjectByIdentifier(projectId);
        return new ResponseEntity<Project>(project,HttpStatus.OK);
    }
    @GetMapping("/all")
    public Iterable<Project> getAllProjects(){
        return projectService.findAllProjects();
    }
    @DeleteMapping("/project/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId){
        projectService.deleteByIdentifier(projectId);
        return new ResponseEntity<String>("project with id '"+projectId+ "' was deleted",HttpStatus.OK);
    }

    @PostMapping("/chand")
    public ResponseEntity<Chand> createNewProject( @Valid @RequestBody Chand chand)
    {
        chandService.saveOrUpdate(chand);
        return new ResponseEntity<Chand>(chand, HttpStatus.CREATED);
    }

    @GetMapping("/helloAshish")
    public String sayHello(){
        return "hii Ashish";
    }
}
