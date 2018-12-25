package com.dzsw.wqh.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper接口
 *  特别注意，该接口不能被扫描到，否则会出错
 * @param <T>
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>
{
}
