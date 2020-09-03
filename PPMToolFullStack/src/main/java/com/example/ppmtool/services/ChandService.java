package com.example.ppmtool.services;

import com.example.ppmtool.domain.Chand;
import com.example.ppmtool.domain.Project;
import com.example.ppmtool.repositories.ChandRepository;
import com.example.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChandService {
    @Autowired
    private ChandRepository chandRepository;

    public Chand saveOrUpdate(Chand chand)
    {
        //logic
//        chandRepository.save(chand);
        return chandRepository.save(chand);
    }
}
