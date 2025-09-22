package dao;

import java.util.List;

import vo.PhotoVo;

public interface PhotoDao {
	
	List<PhotoVo> selectList();
	PhotoVo selecOne(int p_idx);
	
	int insert(PhotoVo vo);
	int update(PhotoVo vo);
	int update_file(PhotoVo vo);
	int delete(int p_idx);

}
