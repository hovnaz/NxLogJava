package HibernateRepository___Task_4;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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

    }
}
