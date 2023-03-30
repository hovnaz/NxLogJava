package HibernateRepository___Task_4;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateRepository {

    private Session session;
    private final EntityManager em;

    public HibernateRepository(EntityManager em) {
        this.em = em;
    }

    /**
     * Returns all modules for agent which are incllded in a complete route.
     * A complete route contains at least 1 INPUT module and at least 1 OUTPUT module.
     */
    public Set<Module> getModulesIncludedInCompleteRoutes(Long agentId) {
        String hql = "SELECT DISTINCT mr.module FROM ModuleRoute mr " +
                "JOIN Route r ON mr.route = r " +
                "JOIN Agent a ON r.agent = a " +
                "WHERE a.id = :agentId AND EXISTS (" +
                "  SELECT r2 FROM Route r2 " +
                "  JOIN ModuleRoute mr2 ON r2 = mr2.route " +
                "  JOIN Module m2 ON mr2.module = m2 " +
                "  WHERE r2 = r AND m2.type = :inputType" +
                ") AND EXISTS (" +
                "  SELECT r3 FROM Route r3 " +
                "  JOIN ModuleRoute mr3 ON r3 = mr3.route " +
                "  JOIN Module m3 ON mr3.module = m3 " +
                "  WHERE r3 = r AND m3.type = :outputType" +
                ")";

        TypedQuery<Module> query = em.createQuery(hql, Module.class);
        query.setParameter("agentId", agentId);
        query.setParameter("inputType", ModuleType.INPUT);
        query.setParameter("outputType", ModuleType.OUTPUT);

        List<Module> resultList = query.getResultList();
        Set<Module> resultSet = new HashSet<>(resultList);
        return resultSet;
    }
}
/*
===/Code===

        Implement the code in getModulesIncludedInCompleteRoutes method using either session or em.Any of Hibernate criteria API,HQL or pure SQL can be used.
*/