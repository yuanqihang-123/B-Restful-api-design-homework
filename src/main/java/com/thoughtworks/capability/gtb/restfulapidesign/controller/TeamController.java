package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.TeamEntity;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeamEntity> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/regroup")
    @ResponseStatus(HttpStatus.OK)
    public List<TeamEntity> getRegroupTeams() {
        return teamService.getRegroupTeams();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamEntity updateTeamName(@PathVariable Integer id, @RequestBody String name){
        return teamService.updateTeamNameById(id, name);
    }

}
