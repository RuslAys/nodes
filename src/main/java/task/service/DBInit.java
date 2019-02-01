package task.service;

import task.dao.api.ConnectionUnitDao;
import task.dao.api.NodeDao;
import task.entity.ConnectionUnit;
import task.entity.Node;
import task.entity.Point;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Singleton
@Startup
public class DBInit implements Serializable {

    @Inject
    private NodeDao nodeDao;

    @Inject
    private ConnectionUnitDao connectionUnitDao;

    @PostConstruct
    private void init(){
        Node node1 = new Node();
        node1.setName("Узел 1");
        node1.setRegion("Центральный");
        node1.setStreet("Марата");
        node1.setHome("18");

        ConnectionUnit connectionUnit1 = new ConnectionUnit();
        connectionUnit1.setName("CU_1");
        connectionUnit1.setCapacity(3);

        Point point11 = new Point();
        point11.setNumber(1);
        connectionUnit1.getPoints().add(point11);

        Point point12 = new Point();
        point12.setNumber(2);
        connectionUnit1.getPoints().add(point12);

        Point point13 = new Point();
        point13.setNumber(3);
        connectionUnit1.getPoints().add(point13);

        ConnectionUnit connectionUnit2 = new ConnectionUnit();
        connectionUnit2.setName("CU_2");
        connectionUnit2.setCapacity(2);

        Point point21 = new Point();
        point21.setNumber(1);
        connectionUnit2.getPoints().add(point21);

        Point point22 = new Point();
        point22.setNumber(2);
        connectionUnit2.getPoints().add(point22);

        Set<ConnectionUnit> connectionUnits = new HashSet<>();
        connectionUnits.add(connectionUnit1);
        connectionUnits.add(connectionUnit2);
        node1.getConnectionUnits().addAll(connectionUnits);

        nodeDao.add(node1);
    }
}
