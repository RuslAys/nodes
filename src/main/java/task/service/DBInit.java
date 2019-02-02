package task.service;

import task.dao.api.ConnectionUnitDao;
import task.entity.ConnectionUnit;
import task.entity.Node;
import task.entity.Point;
import task.service.api.NodeService;

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
    private NodeService nodeService;

    @PostConstruct
    private void init(){
        // init first node
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
        point11.setConnectionUnit(connectionUnit1);
        connectionUnit1.getPoints().add(point11);

        Point point12 = new Point();
        point12.setNumber(2);
        point12.setConnectionUnit(connectionUnit1);
        connectionUnit1.getPoints().add(point12);

        Point point13 = new Point();
        point13.setNumber(3);
        point13.setConnectionUnit(connectionUnit1);
        connectionUnit1.getPoints().add(point13);

        ConnectionUnit connectionUnit2 = new ConnectionUnit();
        connectionUnit2.setName("CU_2");
        connectionUnit2.setCapacity(2);

        Point point21 = new Point();
        point21.setNumber(1);
        point21.setConnectionUnit(connectionUnit2);
        connectionUnit2.getPoints().add(point21);

        Point point22 = new Point();
        point22.setNumber(2);
        point22.setConnectionUnit(connectionUnit2);
        connectionUnit2.getPoints().add(point22);

        point11.setConnectedPoint(point21);
        point21.setConnectedPoint(point11);

        Set<ConnectionUnit> connectionUnits = new HashSet<>();
        connectionUnits.add(connectionUnit1);
        connectionUnits.add(connectionUnit2);
        connectionUnits.forEach(connectionUnit -> connectionUnit.setNode(node1));
        node1.getConnectionUnits().addAll(connectionUnits);

        nodeService.add(node1);

        //init second node
        Node node2 = new Node();
        node2.setName("Узел 2");
        node2.setRegion("Центральный");
        node2.setStreet("Куйбышева");
        node2.setHome("2/A");

        ConnectionUnit connectionUnit3 = new ConnectionUnit();
        connectionUnit3.setName("CU_3");
        connectionUnit3.setCapacity(2);

        Point point31 = new Point();
        point31.setNumber(1);
        point31.setConnectionUnit(connectionUnit3);
        connectionUnit1.getPoints().add(point31);

        Point point32 = new Point();
        point32.setNumber(2);
        point32.setConnectionUnit(connectionUnit3);
        connectionUnit1.getPoints().add(point32);

        ConnectionUnit connectionUnit4 = new ConnectionUnit();
        connectionUnit4.setName("CU_4");
        connectionUnit4.setCapacity(2);

        Point point41 = new Point();
        point41.setNumber(1);
        point41.setConnectionUnit(connectionUnit4);
        connectionUnit2.getPoints().add(point41);

        Point point42 = new Point();
        point42.setNumber(2);
        point42.setConnectionUnit(connectionUnit4);
        connectionUnit2.getPoints().add(point42);

        point31.setConnectedPoint(point41);
        point41.setConnectedPoint(point31);

        Set<ConnectionUnit> connectionUnits2 = new HashSet<>();
        connectionUnits2.add(connectionUnit3);
        connectionUnits2.add(connectionUnit4);
        connectionUnits2.forEach(connectionUnit -> connectionUnit.setNode(node2));
        node2.getConnectionUnits().addAll(connectionUnits2);

        nodeService.add(node2);
    }
}
