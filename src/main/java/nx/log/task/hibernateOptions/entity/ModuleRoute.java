package nx.log.task.hibernateOptions.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "module_route")
public class ModuleRoute extends AbstractEntity {

    @NaturalId
    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "route_id")
    private Route route;
    @NaturalId
    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "module_id")
    private Module module;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
