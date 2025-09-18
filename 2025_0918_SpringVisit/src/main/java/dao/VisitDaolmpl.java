package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVo;

// DAO (Data Access Object)
// : CRUD 처리하는 객체
public class VisitDaolmpl implements VisitDao {
	
	// Spring에서 제공되는 SqlSessionTemplate
	SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
//	
	// 조회
	public List<VisitVo> selectList() {
		List<VisitVo> list = null;

		
		// 2. 작업수행		  mapper_namespace . mapper_select_id
		list = sqlSession.selectList("visit.visit_list");
		
		

		return list;
	}
	
	//검색 조회
	public List<VisitVo> selectList(Map<String, Object> map) {
		List<VisitVo> list = null;

		
		// 2. 작업수행		  (mapper_namespace . mapper_select_id)
		list = sqlSession.selectList("visit.visit_list_condition",map);
		
		return list;
	}
	
	//추가
	public int insert(VisitVo vo) {

		int res = 0;

		
		// 2. 작업수행
		res= sqlSession.insert("visit.visit_insert",vo);

		return res;
	}
	
	//삭제
	public int delete(int idx) {

		int res = 0;

		// 2. 작업수행
		res= sqlSession.delete("visit.visit_delete",idx);
		

		return res;
	}

	
	//idx에 해당하는 1건 데이터 조회
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;

		
		// 2. 작업수행
		vo=sqlSession.selectOne("visit.visit_selectOne", idx);
		
		
		return vo;
	}


	//update
	public int update(VisitVo vo) {

//		int res = 0;
//
//		
//		// 2. 작업수행
//		res=sqlSession.update("visit.visit_update", vo);
		

		return sqlSession.update("visit.visit_update", vo);
	}

	
	
	
	
}//end class
