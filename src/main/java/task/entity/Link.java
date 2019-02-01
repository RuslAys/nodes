package task.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "links")
public class Link extends AbstractPO{
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "phone_number_id")
    @JoinTable(name = "points_links",
            joinColumns = @JoinColumn(name = "point"),
            inverseJoinColumns = @JoinColumn(name = "link"))
    private Point firstPoint;
}
