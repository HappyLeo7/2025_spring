package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDao {
	
	//SqlSessionTemplate sqlSession;
	SqlSession sqlSession;

	// Constructor injection
	public DeptDao(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public List<DeptVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("dept.dept_list");
	}
	
	
}
