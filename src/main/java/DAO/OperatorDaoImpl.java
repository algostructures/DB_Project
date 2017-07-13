package DAO;

import Utilities.JDBCHelper;
import entities.Operator;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by prajapas on 7/13/2017.
 */
public class OperatorDaoImpl implements OperatorDao{

    public List<Operator> getAllOperators() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Operator> operatorList = null;
        try{
            con = JDBCHelper.getConnection();
            String sql = "select * from operator";
            ps = con.prepareStatement(sql);
            ps.execute();
            rs = ps.getResultSet();

            Operator op = null;
            operatorList = new ArrayList<Operator>();

            while(rs.next()) {
                op = new Operator(rs.getString("userName"), rs.getString("name"), rs.getString("password"), rs.getBoolean("blocked"));
                operatorList.add(op);
            }
            return operatorList;
        } catch(SQLException e){
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return null;
        }
        finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }

    public boolean addOpertor(Operator o) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCHelper.getConnection();
            con.setAutoCommit(false);

            String sql = "insert into Operator(userName, name, password, blocked) values (?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, o.getUserName());
            ps.setString(2,o.getName());
            ps.setString(3,o.getPassword());
            ps.setString(4, String.valueOf(o.isBlocked()));

            return true;
        } catch (SQLException e) {
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return false;
        }
        finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }

    public boolean blockOperator(String username) {

        return false;
    }

    public boolean validate(String username, String password) {
        return false;
    }
}
