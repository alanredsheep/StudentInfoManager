package com.redsheep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.redsheep.model.Grade;
import com.redsheep.model.PageBean;
import com.redsheep.util.StringUtil;

public class GradeDao {

	/***
	 * 查询年级
	 * 
	 * @param con
	 * @param pageBean 一页显示的年级数量
	 * @param grade    年级名称模糊查询
	 * @return 年级列表
	 * @throws Exception
	 */
	public ResultSet gradeList(Connection con, PageBean pageBean, Grade grade) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_grade");
		if (grade != null && StringUtil.isEmpty(grade.getGradeName())) {
			sb.append(" and gradeName like '%" + grade.getGradeName() + "%'");
		}

		if (pageBean != null) {
			sb.append(" limit " + pageBean.getStart() + " , " + pageBean.getRows());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	/***
	 * 查询年级数量
	 * 
	 * @param con
	 * @param grade 年级名称模糊查询
	 * @return 年级数量
	 * @throws Exception
	 */
	public int gradeCount(Connection con, Grade grade) throws Exception {
		StringBuffer sql = new StringBuffer("select count(*) as total from t_grade");
		if (StringUtil.isNotEmpty(grade.getGradeName())) {
			sql.append(" and gradeName like '%" + grade.getGradeName() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sql.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}

	/**
	 * 删除年级
	 * 
	 * @param con
	 * @param delIds 要删除的年级的id
	 * @return 成功删除的数量
	 * @throws Exception
	 */
	public int gradeDelete(Connection con, String delIds) throws Exception {
		String sql = "delete from t_grade where id in(" + delIds + ")";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}

	/***
	 * 添加年级
	 * 
	 * @param con
	 * @param grade
	 * @return 成功添加的数量
	 * @throws Exception
	 */
	public int gradeAdd(Connection con, Grade grade) throws Exception {
		String sql = "insert into t_grade values(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, grade.getGradeName());
		pstmt.setString(2, grade.getGradeDesc());
		return pstmt.executeUpdate();
	}

	/***
	 * 修改年级信息
	 * 
	 * @param con
	 * @param grade
	 * @return 成功修改的数量
	 * @throws Exception
	 */
	public int gradeModify(Connection con, Grade grade) throws Exception {
		String sql = "update t_grade set gradeName=?,gradeDesc=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, grade.getGradeName());
		pstmt.setString(2, grade.getGradeDesc());
		pstmt.setInt(3, grade.getId());
		return pstmt.executeUpdate();
	}
}
