package dao;

import java.util.List;
import java.util.Map;

import vo.VisitVo;

// DAO (Data Access Object)
// : CRUD 처리하는 객체
public interface VisitDao {
	
	
	// 조회
	public List<VisitVo> selectList();
	
	//검색 조회
	public List<VisitVo> selectList(Map<String, Object> map);
		
	
	//추가
	public int insert(VisitVo vo);	
	//삭제
	public int delete(int idx);

	
	//idx에 해당하는 1건 데이터 조회
	public VisitVo selectOne(int idx);


	//update
	public int update(VisitVo vo);
	
	
	
	
}//end class
