package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.PhotoVo;

@Repository
public class PhotoDaoImpl implements PhotoDao {

	@Autowired
	SqlSession sqlSession;
	
	
	
	public PhotoDaoImpl() {
		System.out.println("---PhotoDaoImpl()");
	}

	@Override
	public List<PhotoVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("photo.photo_list");
	}

	@Override
	public PhotoVo selecOne(int p_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("photo.photo_one",p_idx);
	}

	@Override
	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("photo.photo_insert", vo);
	}

	@Override
	public int update(PhotoVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("");
	}

	@Override
	public int update_file(PhotoVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int p_idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("photo.photo_delete",p_idx);
	}

}
