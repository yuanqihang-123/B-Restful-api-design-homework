package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.StudentEntity;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.TeamEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TeamService {

    private List<TeamEntity> teams = createTeams(6);

    public List<TeamEntity> getRegroupTeams() {
        cleanTeams();
        for (int i = 0; i < StudentService.students.size(); i++) {
            teams.get(i % 6).getStudents().add(StudentService.students.get(i));
        }
        return teams;
    }

    public List<TeamEntity> getTeams() {
        return teams;
    }

    public TeamEntity updateTeamNameById(Integer id, String name) {
        TeamEntity team = teams.get(id-1);
        team.setName(name);
        return team;
    }

    private List<TeamEntity> createTeams(int count) {
        LinkedList<TeamEntity> teamEntities = new LinkedList<>();
        for (int i = 1; i <= count; i++) {
            teamEntities.add(new TeamEntity(i, "组 " + i, "组 " + i + " 备注", new LinkedList<StudentEntity>()));
        }
        return teamEntities;
    }


    public void cleanTeams() {
        for (int i = 0; i < teams.size(); i++) {
            teams.get(i).setStudents(new LinkedList<StudentEntity>());
        }
    }
}
