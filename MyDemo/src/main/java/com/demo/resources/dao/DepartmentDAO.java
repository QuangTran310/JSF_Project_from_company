package com.demo.resources.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Department;
import com.demo.resources.accessing.ResourcesAccessing;

public class DepartmentDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -818806792833234856L;

	private ResourcesAccessing ra;

	private Connection c;

	private ResultSet rs;

	private Statement stm;

	private PreparedStatement pstm;

	public DepartmentDAO() {
		ra = new ResourcesAccessing();
	}

	// get list departments

	public List<Department> getListDepartments() {
		String query = "select * from department order by id asc;";
		List<Department> listDepartments = new ArrayList<Department>();
		try {
			c = ra.getConnection();
			stm = c.createStatement();
			rs = stm.executeQuery(query);
			while (rs.next()) {
				Department d = new Department();
				d.setId(rs.getInt(1));
				d.setOwner(rs.getString(2));
				d.setPhoneNumber(rs.getString(3));
				d.setCity(rs.getString(4));
				d.setAddress(rs.getString(5));
				d.setOther(rs.getString(6));
				listDepartments.add(d);
			}
			rs.close();
			stm.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDepartments;
	}

	// delete department
	public void deleteDepartment(Integer id) {
		String query = "delete from department where id = ?;";
		try {
			c = ra.getConnection();
			pstm = c.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			pstm.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// update department
	public void updateDepartmentInfor(Department department) {
		String query = "update department set owner = ?, phone_number = ?, city = ?, address = ?, other = ? where id = ?;";
		try {
			c = ra.getConnection();
			pstm = c.prepareStatement(query);
			pstm.setString(1, department.getOwner());
			pstm.setString(2, department.getPhoneNumber());
			pstm.setString(3, department.getCity());
			pstm.setString(4, department.getAddress());
			pstm.setString(5, department.getOther() == null ? "Nothing" : department.getOther());
			pstm.setInt(6, department.getId());
			pstm.executeUpdate();
			pstm.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// insert new department
	public void insertNewDepartment(Department department) {
		String query = "insert into department(owner, phone_number, city, address, other) values (?, ?, ?, ?, ?);";
		try {
			c = ra.getConnection();
			pstm = c.prepareStatement(query);
			pstm.setString(1, department.getOwner());
			pstm.setString(2, department.getPhoneNumber());
			pstm.setString(3, department.getCity());
			pstm.setString(4, department.getAddress());
			pstm.setString(5, department.getOther() == null ? "Nothing" : department.getOther());
			pstm.executeUpdate();
			pstm.close();
			c.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
