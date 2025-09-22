package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	
	
	// 	@Autowired
	//	1. 해당컴포넌트가 자동생성되면 자동연결해준다.
	//	2. 수동생성이면 <bean>등록부분 위에
	//				<context:annotation-config/> 속성을 정의해야한다.
	@Autowired
	SqlSession sqlSession;
	
	public MemberDaoImpl() {
		System.out.println("----MemberDaoImpl()----");
	}
	
	//전체조회 TODO 제네릭 수정하기
	public List<MemberVo> selectList() {
		System.out.println("[Dao selectList() 실행]");
		
		return sqlSession.selectList("member.member_list");
	}
	
	//member에서 회원번호로 1개 조회
	public MemberVo selectOne(int mem_idx) {
		System.out.println("[MemberDao selectOne(int mem_idx) 실행]");
		
		return sqlSession.selectOne("member.member_one",mem_idx);
	}//end selectOne(mem_idx)
	
	
	//로그인시 사용
	public MemberVo selectOne(String mem_id) {
		System.out.println("[MemberDao selectOne(String mem_id) 실행]");
		
		return sqlSession.selectOne("member.member_one_id",mem_id);
	}

	
	//추가
	public int insert(MemberVo vo) {
		System.out.println("[MemberDao insert(MemberVo vo) 실행]");
		
		return sqlSession.insert("member.member_insert",vo);
	}
	
	//삭제
		public int delete(int mem_idx) {
			System.out.println("[MemberDao delete(int mem_idx) 실행]");

			return sqlSession.delete("member.member_delete",mem_idx);
		}
	
	//수정처리
	public int update(MemberVo vo) {
		System.out.println("[MemberDao update(MemberVo vo) 실행]");
		
		return sqlSession.update("member.member_update",vo);
	}
	
}//end : MemberDao class
