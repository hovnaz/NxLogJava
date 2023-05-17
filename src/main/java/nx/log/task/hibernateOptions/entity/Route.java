package nx.log.task.hibernateOptions.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "route")
public class Route extends AbstractEntity {

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

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Set<ModuleRoute> getModuleRoutes() {
        return moduleRoutes;
    }

    public void setModuleRoutes(Set<ModuleRoute> moduleRoutes) {
        this.moduleRoutes = moduleRoutes;
    }
}
