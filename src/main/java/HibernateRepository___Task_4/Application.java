package HibernateRepository___Task_4;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.Set;

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

        FakeDataGenerator.init();

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
