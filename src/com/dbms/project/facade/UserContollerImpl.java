package com.dbms.project.facade;

import java.util.ArrayList;
import java.util.List;

import com.dbms.dao.CreateUserDao;
import com.dbms.vo.EmployeeVO;
import com.dbms.vo.OrdersVO;

/**
 * This is a Facade class that will seperate the controller to the DAO class. It consists of all the necessary DAO methods to populate the 
 * webpages with Data.
 * @author Group 19 SPAR Corp.
 *
 */
public class UserContollerImpl implements UserControllerInterface {
	
	public CreateUserDao userDao = new CreateUserDao();

	@Override
	public List<OrdersVO> getOrderDetailsbyCustomer(String customerID) {
		System.out.println("Enter UserContollerImpl.getOrderDetails()");
		List<OrdersVO> orderDetails = new ArrayList<OrdersVO>();
		orderDetails = userDao.getOrderDetailsByCustomerID(customerID);
		System.out.println("Exit UserContollerImpl.getOrderDetails(");
		return orderDetails;
	}

	@Override
	public List<EmployeeVO> getEmployeeList() {
		System.out.println("Enter UserContollerImpl.getEmployeeList()");
		List<EmployeeVO> emplDetails = new ArrayList<EmployeeVO>();
		emplDetails = userDao.getEmplList();
		System.out.println("Exit UserContollerImpl.getEmployeeList(");
		return emplDetails;
	}
	
	public List<OrdersVO> getOrderDetails() {
		System.out.println("Enter UserContollerImpl.getOrderDetails()");
		List<OrdersVO> orderDetails = new ArrayList<OrdersVO>();
		orderDetails = userDao.getOrderDetails();
		System.out.println("Exit UserContollerImpl.getOrderDetails(");
		return orderDetails;
	}

	@Override
	public void placeOrder(OrdersVO ordersVO) {
		System.out.println("Enter UserContollerImpl.getOrderDetails()");
		userDao.placeOrder(ordersVO);;
		System.out.println("Exit UserContollerImpl.getOrderDetails(");
	}

	@Override
	public List<OrdersVO> getOrderDetails(String orderID) {
		System.out.println("Enter UserContollerImpl.getOrderDetails()");
		List<OrdersVO> orderDetails = new ArrayList<OrdersVO>();
		orderDetails = userDao.getOrderDetails(orderID);
		System.out.println("Exit UserContollerImpl.getOrderDetails(");
		return orderDetails;
	}

	@Override
	public OrdersVO getOrderDetailOnClick(String orderID) {
		System.out.println("Enter UserContollerImpl.getOrderDetails()");
		OrdersVO orderDetails = new OrdersVO();
		orderDetails = userDao.getOrderDetailsfForEdit(orderID);
		System.out.println("Exit UserContollerImpl.getOrderDetails()");
		return orderDetails;
	}

	@Override
	public void updateOrder(OrdersVO vo) {
		System.out.println("Enter UserContollerImpl.updateOrder()");
		OrdersVO orderDetails = new OrdersVO();
		userDao.updateOrder(vo);;
		System.out.println("Exit UserContollerImpl.updateOrder()");
	}


	

}
