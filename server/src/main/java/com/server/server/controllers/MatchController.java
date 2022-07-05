package com.server.server.controllers;

import com.server.server.facade.MatchFacade;
import com.server.server.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MatchController {
    @Autowired
    private MatchFacade matchFacade;
    @Autowired
    private MatchRepository matchRepository;
}
