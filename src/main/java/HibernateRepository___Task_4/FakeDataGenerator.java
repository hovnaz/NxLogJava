package HibernateRepository___Task_4;

import javax.persistence.EntityManager;

public class FakeDataGenerator {

    private final EntityManager entityManager;

    public FakeDataGenerator(EntityManager em) {
        this.entityManager = em;
    }

    public Agent createFakeAgent(String name, AgentType type, String globalConfig) {
        Agent agent = new Agent();
        agent.setName(name);
        agent.setType(type);
        agent.setGlobalConfig(globalConfig);
        entityManager.persist(agent);
        return agent;
    }

    public Module createFakeModule(Agent agent, String name, ModuleType type) {
        Module module = new Module();
        module.setAgent(agent);
        module.setName(name);
        module.setType(type);
        entityManager.persist(module);
        return module;
    }

    public Route createFakeRoute(Agent agent, String name, int priority) {
        Route route = new Route();
        route.setAgent(agent);
        route.setName(name);
        route.setPriority(priority);
        entityManager.persist(route);
        return route;
    }

    public ModuleRoute createFakeModuleRoute(Route route, Module module) {
        ModuleRoute moduleRoute = new ModuleRoute();
        moduleRoute.setRoute(route);
        moduleRoute.setModule(module);
        entityManager.persist(moduleRoute);
        return moduleRoute;
    }
}
