package HibernateRepository___Task_4And5;

import HibernateRepository___Task_4And5.entity.Agent;
import HibernateRepository___Task_4And5.entity.Module;
import HibernateRepository___Task_4And5.entity.ModuleRoute;
import HibernateRepository___Task_4And5.entity.Route;
import HibernateRepository___Task_4And5.repository.HibernateRepository;
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
        Configuration con = configure();
        SessionFactory sessionFactory = buildSessionFactory(con);
        EntityManager entityManager = createEntityManager(sessionFactory);

        HibernateRepository hibernateRepository = new HibernateRepository(entityManager);

        // Replace '1L' with the actual Agent ID you want to query
        Long agentId = 1L;
        Set<Module> modules = hibernateRepository.getModulesIncludedInCompleteRoutes(agentId);

        printModuleNames(modules);

        closeResources(entityManager, sessionFactory);
    }

    private Configuration configure() {
        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(Agent.class);
        con.addAnnotatedClass(Module.class);
        con.addAnnotatedClass(Route.class);
        con.addAnnotatedClass(ModuleRoute.class);
        return con;
    }

    private SessionFactory buildSessionFactory(Configuration con) {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties());

        FakeDataGenerator.init();

        return con.buildSessionFactory(registryBuilder.build());
    }

    private EntityManager createEntityManager(SessionFactory sessionFactory) {
        return sessionFactory.createEntityManager();
    }

    private void printModuleNames(Set<Module> modules) {
        modules.stream().map(Module::getName).forEach(System.out::println);
    }

    private void closeResources(EntityManager entityManager, SessionFactory sessionFactory) {
        entityManager.close();
        sessionFactory.close();
    }
}
