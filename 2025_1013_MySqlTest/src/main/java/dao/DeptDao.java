package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vo.DeptVo;

@Repository
public interface DeptDao {

	List<DeptVo> selectList();
}
