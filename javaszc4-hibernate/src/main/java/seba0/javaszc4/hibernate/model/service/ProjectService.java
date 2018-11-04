package seba0.javaszc4.hibernate.model.service;

import org.hibernate.Session;
import seba0.javaszc4.hibernate.model.entity.Project;

public class ProjectService extends EntityService<Project> {

    public ProjectService(Session session) {
        super(session, Project.class);
    }
}
