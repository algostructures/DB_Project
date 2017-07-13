package DAO;

import Utilities.JDBCHelper;
import entities.SpareParts;

import java.sql.*;
import java.util.List;

/**
 * Created by prajapas on 7/13/2017.
 */
public class SparePartsDaoImpl implements SparePartsDao{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<SpareParts> getAllSpareParts() {
        try{
            con = JDBCHelper.getConnection();
            String sql = "select * from customer";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                SpareParts sp = new SpareParts(rs.getString("sparepartId"), rs.getString("sparepartName"),
                        rs.getString("vehicle_model"),rs.getDouble("price"), rs.getDouble("tax"), rs.getInt("units"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addSparePart(SpareParts sparePart) {
        return false;
    }

    public boolean removeSpareParts(SpareParts id, int number) {
        return false;
    }
}
