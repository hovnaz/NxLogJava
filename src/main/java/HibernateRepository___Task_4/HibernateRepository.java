package HibernateRepository___Task_4;

import org.hibernate.Session;

import java.util.Set;

public class HibernateRepository {

    private Session session;
    //private EntityManager em;

    /**
     * Returns all modules for agent which are incllded in a complete route.
     * A complete route contains at least 1 INPUT module and at least 1 OUTPUT module.
     */
    public Set<Module> getModulesIncludedInCompleteRoutes(Long agentId) {
        //TODO Implement
        return null;
    }
}
/*
===/Code===

        Implement the code in getModulesIncludedInCompleteRoutes method using either session or em.Any of Hibernate criteria API,HQL or pure SQL can be used.
*/