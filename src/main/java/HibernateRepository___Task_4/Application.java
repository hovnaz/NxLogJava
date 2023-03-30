package HibernateRepository___Task_4;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application implements Runnable {


    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    @Override
    public void run() {

        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(Agent.class);
        con.addAnnotatedClass(Module.class);
        con.addAnnotatedClass(Route.class);
        con.addAnnotatedClass(ModuleRoute.class);

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties());

        SessionFactory st = con.buildSessionFactory(registryBuilder.build());


        // Instantiate an EntityManager object using Hibernate's EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

// Call the generateAndSaveFakeData method and pass the EntityManager object to it
        generateAndSaveFakeData(entityManager);

// Close the EntityManager and EntityManagerFactory when you're done using them
        entityManager.close();
        entityManagerFactory.close();
    }

    private void generateAndSaveFakeData(EntityManager entityManager) {
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
}


//    @Override
//    public void run() {
//
//        Configuration con = new Configuration().configure();
//        con.addAnnotatedClass(Agent.class);
//        con.addAnnotatedClass(Module.class);
//        con.addAnnotatedClass(Route.class);
//        con.addAnnotatedClass(ModuleRoute.class);
//
//        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
//                .applySettings(con.getProperties());
//
//        SessionFactory sessionFactory = con.buildSessionFactory(registryBuilder.build());
//        EntityManager entityManager = sessionFactory.createEntityManager();
//
//        HibernateRepository hibernateRepository = new HibernateRepository(entityManager);
//
//        // Replace '1L' with the actual Agent ID you want to query
//        Long agentId = 1L;
//        Set<Module> modules = hibernateRepository.getModulesIncludedInCompleteRoutes(agentId);
//
//        // Do something with the retrieved modules, e.g., print their names
//        System.out.println(modules);
//        for (Module module : modules) {
//            System.out.println("Module name: " + module.getName());
//        }
//
//        // Clean up resources
//        entityManager.close();
//        sessionFactory.close();
//    }
