package task.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "connection_units")
public class ConnectionUnit extends AbstractPO{
    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private Integer capacity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "connectionUnit")
    private Set<Point> points = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "node_id")
    private Node node;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
