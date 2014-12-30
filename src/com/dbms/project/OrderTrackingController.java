package com.dbms.project;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import com.dbms.project.facade.UserContollerImpl;
import com.dbms.vo.EmployeeVO;
import com.dbms.vo.OrdersVO;
/**
 * This is a controller that will take care of most of the functionalities that are present in the web module such as track order, create order,
 * track order specific to a customer, get all orders and place order
 * @author Group 19 SPAR Corp.
 *
 */
@ManagedBean
public class OrderTrackingController {

	private OrdersVO ordersVO;
	public UserContollerImpl contollerImpl = new UserContollerImpl();
	public List<OrdersVO> orderDetails;
	public List<OrdersVO> orderDetailsByCustomer;
	private List<EmployeeVO> emplDetailsList;

	public OrderTrackingController(){
		ordersVO = new OrdersVO();
	}
	
	public String trackOrder() {
		System.out.println("Enter OrderTrackingController.trackOrder()");
		orderDetails = new ArrayList<OrdersVO>();
		orderDetails = contollerImpl.getOrderDetails(ordersVO.getOrderID().toString());
		System.out.println("orderDetails--->>"+orderDetails.size());
		System.out.println("Exit OrderTrackingController.trackOrder()");
		return "orderTrackingPage";
	}
	
	public String trackOrderByCustomer() {
		System.out.println("Enter OrderTrackingController.trackOrderByCustomer()");
		orderDetailsByCustomer = new ArrayList<OrdersVO>();
		System.out.println("Customer ID ---->"+ordersVO.getCustomerID().toString());
		orderDetailsByCustomer = contollerImpl.getOrderDetailsbyCustomer(ordersVO.getCustomerID().toString());
		System.out.println("Exit OrderTrackingController.trackOrderByCustomer()");
		return "orderTrackingPageCustomer";
	}
	
	public String getAllOrder() {
		System.out.println("Enter OrderTrackingController.getAllOrder()");
		orderDetails = new ArrayList<OrdersVO>();
		orderDetails = contollerImpl.getOrderDetails();
		System.out.println("Exit OrderTrackingController.getAllOrder()");
		return "getAllOrders";
	}
	
	public String onClickGetOrderDetails(OrdersVO o){
		System.out.println("Enter OrderTrackingController.onClickGetOrderDetails()");
		ordersVO = contollerImpl.getOrderDetailOnClick(o.getOrderID().toString());
		System.out.println("Exit OrderTrackingController.onClickGetOrderDetails()" );
		return "editOrder";
	}
	
	public String updateOrder(){
		System.out.println("Enter OrderTrackingController.updateOrder()");
		contollerImpl.updateOrder(ordersVO);;
		System.out.println("Exit OrderTrackingController.updateOrder()" );
		return "homepage";
	}
	
	public String getEmplList(){
		emplDetailsList = contollerImpl.getEmployeeList();
		return "emplDetailsList";
	}
	
	public String placeOrder(){
		contollerImpl.placeOrder(ordersVO);
		return "homePage";
	}


	public OrdersVO getOrdersVO() {
		return ordersVO;
	}


	public void setOrdersVO(OrdersVO ordersVO) {
		this.ordersVO = ordersVO;
	}


	public List<OrdersVO> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(List<OrdersVO> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<EmployeeVO> getEmplDetailsList() {
		return emplDetailsList;
	}

	public void setEmplDetailsList(List<EmployeeVO> emplDetailsList) {
		this.emplDetailsList = emplDetailsList;
	}

	public List<OrdersVO> getOrderDetailsByCustomer() {
		return orderDetailsByCustomer;
	}

	public void setOrderDetailsByCustomer(List<OrdersVO> orderDetailsByCustomer) {
		this.orderDetailsByCustomer = orderDetailsByCustomer;
	}
}
