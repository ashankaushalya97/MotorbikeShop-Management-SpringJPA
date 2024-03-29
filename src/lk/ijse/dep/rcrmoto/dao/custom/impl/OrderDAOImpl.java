package lk.ijse.dep.rcrmoto.dao.custom.impl;

import lk.ijse.dep.rcrmoto.dao.CrudDAOImpl;
import lk.ijse.dep.rcrmoto.dao.custom.OrdersDAO;
import lk.ijse.dep.rcrmoto.entity.Orders;
import org.springframework.stereotype.Component;

import javax.persistence.Query;

@Component
public class OrderDAOImpl extends CrudDAOImpl<Orders,String> implements OrdersDAO {

    @Override
    public String getLastOrderId() throws Exception {
        Query nativeQuery = entityManager.createNativeQuery("SELECT order_id FROM Orders ORDER BY order_id DESC LIMIT 1");
        return nativeQuery.getResultList().size() > 0 ? (String) nativeQuery.getSingleResult() : null;
    }
}
