package nx.log.task.hibernateOptions.entity;

import nx.log.task.hibernateOptions.model.AgentType;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Table(name = "agent")
@Entity
public class Agent extends AbstractEntity {

    @Column(name = "name", length = 127, nullable = false, unique = true)
    protected String name;
    @Column(nullable = false, length = 31)
    @Enumerated(EnumType.STRING)
    private AgentType type;
    @Basic(fetch = FetchType.LAZY)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AgentType getType() {
        return type;
    }

    public void setType(AgentType type) {
        this.type = type;
    }

    //task_V
    public String getGlobalConfig() {
        if (Hibernate.isInitialized(globalConfig)) {
            return globalConfig;
        }
        Hibernate.initialize(globalConfig);
        return globalConfig;
    }

    public void setGlobalConfig(String globalConfig) {
        this.globalConfig = globalConfig;
    }

    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
}
