package HibernateRepository___Task_4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

    private static void generateAndSaveFakeData(EntityManager entityManager) {
        FakeDataGenerator fakeDataGenerator = new FakeDataGenerator(entityManager);

        // Generate and save fake data
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Agent fakeAgent = fakeDataGenerator.createFakeAgent("Fake Agent", AgentType.API, "Fake global config");

        Module inputModule = fakeDataGenerator.createFakeModule(fakeAgent, "Fake Input Module", ModuleType.INPUT);
        Module outputModule = fakeDataGenerator.createFakeModule(fakeAgent, "Fake Output Module", ModuleType.OUTPUT);

        Route fakeRoute = fakeDataGenerator.createFakeRoute(fakeAgent, "Fake Route", 1);

        fakeDataGenerator.createFakeModuleRoute(fakeRoute, inputModule);
        fakeDataGenerator.createFakeModuleRoute(fakeRoute, outputModule);

        transaction.commit();
    }

    public static void init() {
        // Instantiate an EntityManager object using Hibernate's EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Call the generateAndSaveFakeData method and pass the EntityManager object to it
        generateAndSaveFakeData(entityManager);

        // Close the EntityManager and EntityManagerFactory when you're done using them
        entityManager.close();
        entityManagerFactory.close();
    }
}
