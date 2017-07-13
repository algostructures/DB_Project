package DAO;

import Utilities.JDBCHelper;
import entities.Orders;
import entities.SpareParts;
import entities.Vehicle;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by prajapas on 7/13/2017.
 */
public class OrderDaoImpl implements OrderDao {

    public List<Orders> getAllOrders() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Orders> OrderList = null;
        try{
            con = JDBCHelper.getConnection();
            String sql = "select * from orders";
            ps = con.prepareStatement(sql);
            ps.execute();
            rs = ps.getResultSet();
            while(rs.next()){
                Orders or = new Orders(rs.getString("1"),rs.getString(2), rs.getString(3),
                        rs.getString(4),rs.getString(5), rs.getInt(6), rs.getDouble(7),
                        rs.getDouble(8), new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString(9)));
                OrderList.add(or);
            }
            return OrderList;
        } catch (SQLException e) {
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }

    public List<Orders> getOrders(Date from, Date to) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Orders> OrderList = null;
        try{
            con = JDBCHelper.getConnection();
            String sql = "select * from orders";
            ps = con.prepareStatement(sql);
            ps.execute();
            rs = ps.getResultSet();
            while(rs.next()){
                Date tempDate = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString(9));
                if(tempDate.after(from) && tempDate.before(to)) {
                    Orders or = new Orders(rs.getString("1"), rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDouble(7),
                            rs.getDouble(8), new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString(9)));
                    OrderList.add(or);
                }
            }
            return OrderList;
        } catch (SQLException e) {
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }

    public boolean placeOrder(Orders order) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = JDBCHelper.getConnection();
            con.setAutoCommit(false);
            String sql = "insert into orders values (?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,order.getOrderedBy());
            ps.setString(2, order.getOrderId());
            ps.setString(3, order.getVehicleModel());
            ps.setString(4, order.getSparePart());
            ps.setString(5, order.getOperation());
            ps.setInt(6, order.getNumbers());
            ps.setDouble(7, order.getPrice());
            ps.setDouble(8, order.getTax());
            ps.setString(9, order.getDate().toString());
            ps.executeUpdate();
            if(order.getSparePart().length() == 0){
                Vehicle vehicle = new Vehicle(order.getVehicleModel(), order.getNumbers(), order.getPrice(), order.getTax());
                VehicleDaoImpl vd = new VehicleDaoImpl();
                vd.addVehicle(vehicle);
            }
            else{
                SpareParts spareParts = new SpareParts(order.getVehicleModel(), order.getSparePart(), order.getPrice(), order.getTax(), order.getNumbers());
                SparePartsDaoImpl sp = new SparePartsDaoImpl();
                sp.addSparePart(spareParts);
            }
            con.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return false;
        }  finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }
}
