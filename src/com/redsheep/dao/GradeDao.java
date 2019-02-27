package com.redsheep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.redsheep.model.Grade;
import com.redsheep.model.PageBean;
import com.redsheep.util.StringUtil;

public class GradeDao {

	/***
	 * ��ѯ�꼶
	 * 
	 * @param con
	 * @param pageBean һҳ��ʾ���꼶����
	 * @param grade    �꼶����ģ����ѯ
	 * @return �꼶�б�
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
	 * ��ѯ�꼶����
	 * 
	 * @param con
	 * @param grade �꼶����ģ����ѯ
	 * @return �꼶����
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
	 * ɾ���꼶
	 * 
	 * @param con
	 * @param delIds Ҫɾ�����꼶��id
	 * @return �ɹ�ɾ��������
	 * @throws Exception
	 */
	public int gradeDelete(Connection con, String delIds) throws Exception {
		String sql = "delete from t_grade where id in(" + delIds + ")";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}

	/***
	 * ����꼶
	 * 
	 * @param con
	 * @param grade
	 * @return �ɹ���ӵ�����
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
	 * �޸��꼶��Ϣ
	 * 
	 * @param con
	 * @param grade
	 * @return �ɹ��޸ĵ�����
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
