package com.dbms.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbms.vo.EmployeeVO;
import com.dbms.vo.OrdersVO;
/**
 * This is a DAO class that makes the necessary DB calls. The password needs to be reset as the local password and DB URL needs to be updated
 * according to the DB that is being created.
 * @author Group 19 SPAR Corp.
 *
 */

public class CreateUserDao {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String USER = "root";
	static final String PASS = "";
	static final String DB_URL = "jdbc:mysql://localhost/SPAR";
	public Connection conn;
	public PreparedStatement stmt;

	public void updateOrder(OrdersVO vo) {
		System.out.println("Enter CreateUserDao.updateOrder()");
		try {
			System.out.println("In Create User");
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "Update orderd set SenderName = ?, ReceiverName = ? where orderID = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getSenderName());
			stmt.setString(2, vo.getReceiverName());
			stmt.setString(3, vo.getOrderID());
			stmt.executeUpdate();
			System.out.println("Exit CreateUserDao.updateOrder()");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<OrdersVO> getOrderDetails(String orderID) {
		System.out.println("Enter CreateUserDao.getOrderDetails()");

		List<OrdersVO> orderDetails = new ArrayList<OrdersVO>();
		boolean isUser = false;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "SELECT  o.OrderID, o.SenderName, o.ReceiverName, o.ReceiverAddress, t.LocID, l.LocName, t.DateofArrival FROM TrackOrders AS t, OrderD AS o, Location AS l WHERE o.orderID = ? and  o.OrderID = t.OrderID AND t.LocID = l.LocID ORDER BY DateofArrival";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, orderID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				OrdersVO orderVo = new OrdersVO();
				orderVo.setOrderID(rs.getString(1));
				orderVo.setSenderName(rs.getString(2));
				orderVo.setReceiverName(rs.getString(3));
				orderVo.setRecieverAddress(rs.getString(4));
				orderVo.setLocationID(rs.getString(5));
				orderVo.setLocationName(rs.getString(6));
				orderVo.setDateOfArrival(rs.getString(7));
				orderDetails.add(orderVo);
			}
			System.out.println("Exit CreateUserDao.getOrderDetails()");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderDetails;

	}

	public OrdersVO getOrderDetailsfForEdit(String orderID) {
		System.out.println("Enter CreateUserDao.getOrderDetails()");
		OrdersVO orderVo = new OrdersVO();
		try {

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "SELECT  o.OrderID, o.SenderName, o.ReceiverName, o.ReceiverAddress, t.LocID, l.LocName, t.DateofArrival,  o.DateOfOrder FROM TrackOrders AS t, OrderD AS o, Location AS l WHERE o.orderID = ? and  o.OrderID = t.OrderID AND t.LocID = l.LocID ORDER BY DateofArrival";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, orderID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				orderVo.setOrderID(rs.getString(1));
				orderVo.setSenderName(rs.getString(2));
				orderVo.setReceiverName(rs.getString(3));
				orderVo.setRecieverAddress(rs.getString(4));
				orderVo.setLocationID(rs.getString(5));
				orderVo.setLocationName(rs.getString(6));
				orderVo.setDateOfArrival(rs.getString(7));
				orderVo.setDateOfOrder(rs.getString(8));
			}
			System.out.println("OrderID...." + orderVo.getOrderID());
			System.out.println("Exit CreateUserDao.getOrderDetails()");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderVo;

	}
	
	public List<OrdersVO> getOrderDetailsByCustomerID(String customerID) {
		System.out.println("Enter CreateUserDao.getOrderDetails()");

		List<OrdersVO> orderDetails = new ArrayList<OrdersVO>();
		boolean isUser = false;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "SELECT c.custName, o.OrderID, o.ReceiverName,o. DateOfOrder FROM Customers as c, OrderD as o, PlaceOrders as p WHERE  c.custID = ? and c.CustID = p.CustID AND p.OrderID = o.OrderID ORDER BY o.OrderID";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				OrdersVO orderVo = new OrdersVO();
				orderVo.setSenderName(rs.getString(1));
				orderVo.setOrderID(rs.getString(2));
				orderVo.setReceiverName(rs.getString(3));
				orderVo.setDateOfOrder(rs.getString(4));
				orderDetails.add(orderVo);
			}
			System.out.println("Exit CreateUserDao.getOrderDetails()");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderDetails;

	}

	public List<OrdersVO> getOrderDetails() {
		System.out.println("Enter CreateUserDao.getOrderDetails()");

		List<OrdersVO> orderDetails = new ArrayList<OrdersVO>();
		boolean isUser = false;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "SELECT OrderID, SenderName, ReceiverName, DateOfOrder FROM orderd ";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				OrdersVO orderVo = new OrdersVO();
				orderVo.setOrderID(rs.getString(1));
				orderVo.setReceiverName(rs.getString(3));
				orderVo.setSenderName(rs.getString(2));
				orderVo.setDateOfOrder(rs.getString(4));
				orderDetails.add(orderVo);
			}
			System.out.println("Exit CreateUserDao.getOrderDetails()");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderDetails;

	}

	public List<EmployeeVO> getEmplList() {
		System.out.println("Enter CreateUserDao.getOrderDetails()");

		List<EmployeeVO> emplDetails = new ArrayList<EmployeeVO>();
		boolean isUser = false;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "SELECT EmpID, EmpName, EmpAddress, EmpDOB, EmpPhone, DeptName, e.Designation, Salary FROM employee e, payroll p WHERE e.Designation = p.Designation";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EmployeeVO employeeVO = new EmployeeVO();
				employeeVO.setEmpID(rs.getString(1));
				employeeVO.setEmpName(rs.getString(2));
				employeeVO.setEmpAddress(rs.getString(3));
				employeeVO.setEmpDOB(rs.getString(4));
				employeeVO.setEmpPhone(rs.getString(5));
				employeeVO.setDeptName(rs.getString(6));
				employeeVO.setDesignation(rs.getString(7));
				employeeVO.setEmpSalary(rs.getString(8));
				emplDetails.add(employeeVO);
			}
			System.out.println("Exit CreateUserDao.getOrderDetails()");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emplDetails;

	}

	public void placeOrder(OrdersVO ordersVO) {
		System.out.println("Enter CreateUserDao.placeOrder()");

		List<EmployeeVO> emplDetails = new ArrayList<EmployeeVO>();
		boolean isUser = false;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "INSERT INTO orderd(OrderID, SenderName, ReceiverName, DateOfOrder) VALUES (?,?,?,?);";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ordersVO.getOrderID());
			stmt.setString(2, ordersVO.getSenderName());
			stmt.setString(3, ordersVO.getReceiverName());
			stmt.setString(4, ordersVO.getDateOfOrder());
			stmt.executeUpdate();
			System.out.println("Exit CreateUserDao.placeOrder()");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		CreateUserDao dao = new CreateUserDao();
	}
}
