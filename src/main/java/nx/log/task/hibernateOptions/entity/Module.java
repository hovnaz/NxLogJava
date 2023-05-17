package nx.log.task.hibernateOptions.entity;

import nx.log.task.hibernateOptions.model.ModuleType;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.CascadeType.DETACH;

@Entity
@Table(name = "module")
public class Module extends AbstractEntity {

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

    public ModuleType getType() {
        return type;
    }

    public void setType(ModuleType type) {
        this.type = type;
    }
}
