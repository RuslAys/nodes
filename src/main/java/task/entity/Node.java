package task.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "nodes")
public class Node extends AbstractPO{
    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "street")
    private String street;

    @Column(name = "home")
    private String home;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "node")
    private Set<ConnectionUnit> connectionUnits = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Set<ConnectionUnit> getConnectionUnits() {
        return connectionUnits;
    }

    public void setConnectionUnits(Set<ConnectionUnit> connectionUnits) {
        this.connectionUnits = connectionUnits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name) &&
                Objects.equals(region, node.region) &&
                Objects.equals(street, node.street) &&
                Objects.equals(home, node.home);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, street, home);
    }

    @Override
    public String toString() {
        return name;
    }
}
