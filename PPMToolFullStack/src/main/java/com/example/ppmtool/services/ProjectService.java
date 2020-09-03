package com.example.ppmtool.services;

import com.example.ppmtool.domain.Project;
import com.example.ppmtool.exceptions.ProjectIdException;
import com.example.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project)
    {
       try{
           project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
           return projectRepository.save(project);

       }
       catch(Exception ex) {
           throw new ProjectIdException("project Id '" + project.getProjectIdentifier() + "' already exits ");
       }
    }

    public Project findProjectByIdentifier(String projectId)
    {
        Project project=projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project==null)
        {
            throw new ProjectIdException("project Id '"+projectId+"' does not exits ");
        }
        return project;
    }
    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteByIdentifier(String projectId)
    {
        Project project=projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project==null)
        {
            throw new ProjectIdException("connot delete project with id '"+projectId+"'." +
                    " This project does not exits");
        }
        projectRepository.delete(project);
    }

}
