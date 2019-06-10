package com.zj.mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: BaseMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ljt
 * @date 2018-12-14 上午8:38:38 * *
 */
public interface BaseMapper<T> {
	// 添加一条
	int add(T t) throws Exception;

	// 删除
	int delete(String id)throws Exception;

	// 修改
	int update(T t)throws Exception;

	// 根据对象属性查询
	List<T> find(T t)throws Exception;

	// 分页查询
	List<T> findByPage(Map<String, Object> map)throws Exception;

	// 统计数量
	int findCount(Map<String, Object> map)throws Exception;

	// 根据多个id查询
	List<T> findByIds(String[] ids)throws Exception;

	// 批量添加
	int batchAdd(List<T> list)throws Exception;

	// 批量删除
	int batchDelete(String[] ids)throws Exception;

}
