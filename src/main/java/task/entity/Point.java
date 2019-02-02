package task.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "points")
public class Point extends AbstractPO{
    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "connection_unit_id")
    private ConnectionUnit connectionUnit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "connected_point_id")
    private Point connectedPoint;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ConnectionUnit getConnectionUnit() {
        return connectionUnit;
    }

    public void setConnectionUnit(ConnectionUnit connectionUnit) {
        this.connectionUnit = connectionUnit;
    }

    public Point getConnectedPoint() {
        return connectedPoint;
    }

    public void setConnectedPoint(Point connectedPoint) {
        this.connectedPoint = connectedPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(number, point.number) &&
                Objects.equals(connectionUnit, point.connectionUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, connectionUnit);
    }
}
