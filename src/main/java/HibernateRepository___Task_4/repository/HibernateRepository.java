package HibernateRepository___Task_4.repository;

import HibernateRepository___Task_4.entity.Module;
import HibernateRepository___Task_4.model.ModuleType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

public class HibernateRepository {

    @PersistenceContext
    private final EntityManager em;

    public HibernateRepository(EntityManager em) {
        this.em = em;
    }

    /**
     * Returns all modules for agent which are included in a complete route.
     * A complete route contains at least 1 INPUT module and at least 1 OUTPUT module.
     */
    public Set<Module> getModulesIncludedInCompleteRoutes(Long agentId) {
        String hql = "SELECT m FROM Module m " +
                "WHERE m.agent.id = :agentId AND m IN (" +
                "    SELECT mr.module FROM ModuleRoute mr " +
                "    WHERE mr.route IN (" +
                "        SELECT r FROM Route r " +
                "        WHERE r.agent.id = :agentId AND EXISTS (" +
                "            SELECT mr1 FROM ModuleRoute mr1 " +
                "            WHERE mr1.route = r AND mr1.module.type = :inputType" +
                "        ) AND EXISTS (" +
                "            SELECT mr2 FROM ModuleRoute mr2 " +
                "            WHERE mr2.route = r AND mr2.module.type = :outputType" +
                "        )" +
                "    )" +
                ")";

        TypedQuery<Module> query = em.createQuery(hql, Module.class);
        query.setParameter("agentId", agentId);
        query.setParameter("inputType", ModuleType.INPUT);
        query.setParameter("outputType", ModuleType.OUTPUT);

        return new HashSet<>(query.getResultList());
    }
}
/*
===/Code===

        Implement the code in getModulesIncludedInCompleteRoutes method using either session or em.Any of Hibernate criteria API,HQL or pure SQL can be used.
*/