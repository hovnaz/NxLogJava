# NXLog Java Hibernate test tasks

## Task I

The following method compares product version in the format "<major_version>.<minor_version>.<build_number>" and gives
greater or equal result for current version.

### Code

    public static boolean isCurrentVersionHigherOrEqual(String agentVersion, String currentAgentVersion) {
        boolean result = false;
        if (!comparator.comparator.ValidationUtils.isEmptyString(currentAgentVersion) && !comparator.comparator.ValidationUtils.isEmptyString(agentVersion)) {
            String _currentAgentVersion = currentAgentVersion.replaceAll("\\.", "");
            String _agentVersion = agentVersion.replaceAll("\\.", "");
            result = Integer.valueOf(_currentAgentVersion) >= Integer.valueOf(_agentVersion);
        }

        return result;
    }

### Code

Is there a problem in the code which will give incorrect result for some values, and if there is write solution which
will give the correct result.

## Task II

The following code contains 2 Threads running once:

### Code

```
public class syncUtil.SynchroProcessor {

    private syncUtil.Processor processor;

    public static void main(String[] args) {
	Thread t1 = new Executor().start();
	Thread t2 = new Initializer().start();

	System.exit(0);
    }

    private class Initializer extend Thread {
	public void run() {
	    processor = new syncUtil.Processor();
	    processor.init();
	}
    }
    private class Executor extend Thread {
	public void run() {
	    processor.process();
	}
    }
}
```

### Code

Write modified code which ensures the processor in Executor is always initialized when process() method is executed.

## Task III

The following code filters elements from a collection by statuses to another collection:

### Code

```
final List<colectionUtil.AgentInfoBean> agentInfos = fetchItems();
List<colectionUtil.AgentInfoBean> filteredResults = new LinkedList<colectionUtil.AgentInfoBean>();
for (colectionUtil.AgentInfoBean item : agentInfos) {
    if (states.contains(item.getStatus())) {
        filteredResults.add(item);
    }
}
```

### Code

Rewrite this code using Java8 stream and functions API.

## Task IV

We have the following Hibernate model and Repository class:

### Code

```
public enum ModuleType {
    INPUT,
    OUTPUT,
    PROCESSOR,
    EXTENSION
}
```

```
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    //getters and setters skipped for briefity.
}
```

```
@Entity
public class Agent extends AbstractAclEntity {

    @Column(name = "name", length = 127, nullable = false, unique = true)
    protected String name;
    @Column(nullable = false, length = 31)
    @Enumerated(EnumType.STRING)
    private AgentType type;
    @Column(name = "global_config", length = 32671)
    @Lob
    protected String globalConfig;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id")
    protected Set<Route> routes = new LinkedHashSet<>();
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    protected Set<Module> modules = new LinkedHashSet<>();

    //getters and setters skipped for briefity.
}
```

```
@Entity
public class Module extends AbstractAclEntity {

    @NaturalId
    @ManyToOne(cascade = DETACH)
    @JoinColumn(name = "agent_id")
    private Agent agent;
    @NaturalId
    @Column(name = "name", length = 128)
    private String name;
    @Column(nullable = false, length = 31)
    @Enumerated(EnumType.STRING)
    private ModuleType type;

    //getters and setters skipped for briefity.
}
```

```

@Entity
public class Route extends AbstractAclEntity {

    @NaturalId
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "agent_id")
    private Agent agent;
    @NaturalId
    @Column(name = "name", length = 128)
    private String name;
    @Column(name = "priority")
    private Integer priority;
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id")
    private Set<ModuleRoute> moduleRoutes = new LinkedHashSet<>();

    //getters and setters skipped for briefity.
}
 ```

```
@Entity
public class ModuleRoute extends AbstractAclEntity {

    @NaturalId
    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "route_id")
    private Route route;
    @NaturalId
    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "module_id")
    private Module module;

    //getters and setters skipped for briefity.
}
```

```

public class HibernateRepository {

    private Session session;
    //private EntityManager em;

    /**
     * Returns all modules for agent which are incllded in a complete route.
     * A complete route contains at least 1 INPUT module and at least 1 OUTPUT module.
     */
    public Set<Module> getModulesIncludedInCompleteRoutes(Long agentId) {
    //TODO Implement
    }
}
```

### Code

Implement the code in getModulesIncludedInCompleteRoutes method using either session or em. Any of Hibernate criteria
API, HQL or pure SQL can be used.

## Task V

Let's have the above Hibernate model in Task IV and more secificly the Agent entity. We don't need globalConfig each
time in Hibernate and as @Lob this can be large data. Modify the model so globalConfig is only fetched when needed, i.e.
session.get(agentId, Agent.class) will return Agent without globalConfig data.
