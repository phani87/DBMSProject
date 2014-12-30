package com.dbms.project.facade;

import java.util.List;

import com.dbms.vo.EmployeeVO;
import com.dbms.vo.OrdersVO;

public interface UserControllerInterface {

//	public boolean userLoginCheck(UserVO userVo);
//	public void createNewUser(UserVO userVO);
	public List<EmployeeVO> getEmployeeList();
	public List<OrdersVO> getOrderDetails(String orderID);
	public List<OrdersVO> getOrderDetailsbyCustomer(String customerID);
	public List<OrdersVO> getOrderDetails();
	public void placeOrder(OrdersVO ordersVO);
	public OrdersVO getOrderDetailOnClick(String orderID);
	public void updateOrder(OrdersVO vo);
	
	
	
	
}
