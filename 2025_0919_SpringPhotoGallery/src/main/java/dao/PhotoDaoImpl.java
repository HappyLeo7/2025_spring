package dao;

import java.util.List;
import java.util.Map;

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
		return sqlSession.update("photo.photo_update",vo);
	}

	@Override
	public int update_filename(PhotoVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("photo.photo_update_filename",vo);
	}

	@Override
	public int delete(int p_idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("photo.photo_delete",p_idx);
	}

	
	/**페이지 처리해서 전체조회해오기*/
	@Override
	public List<PhotoVo> selectList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("photo.photo_page_list",map);
	}

	@Override
	public int selectRowTotal() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("photo.photo_row_total");
	}

}
