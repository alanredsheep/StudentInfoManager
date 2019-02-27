package com.redsheep.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redsheep.dao.StudentDao;
import com.redsheep.model.Student;
import com.redsheep.util.DateUtil;
import com.redsheep.util.DbUtil;
import com.redsheep.util.ResponseUtil;
import com.redsheep.util.StringUtil;

import net.sf.json.JSONObject;

public class StudentSaveServlet extends HttpServlet {
	DbUtil dbUtil = new DbUtil();
	StudentDao studentDao = new StudentDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String gradeId = request.getParameter("gradeId");
		String email = request.getParameter("email");
		String stuDesc = request.getParameter("stuDesc");
		String stuId = request.getParameter("stuId");

		Student student = null;
		try {
			student = new Student(stuNo, stuName, sex, DateUtil.formatString(birthday, "yyyy-MM-dd"),
					Integer.parseInt(gradeId), email, stuDesc);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (StringUtil.isNotEmpty(stuId)) {
			student.setStuId(Integer.parseInt(stuId));
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNums = 0;
			JSONObject result = new JSONObject();
			if (StringUtil.isNotEmpty(stuId)) {
				saveNums = studentDao.studentModify(con, student);
			} else {
				saveNums = studentDao.studentAdd(con, student);
			}
			if (saveNums > 0) {
				result.put("success", "true");
			} else {
				result.put("success", "true");
				result.put("errorMsg", "保存失败");
			}
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
