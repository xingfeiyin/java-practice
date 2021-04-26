package com.yinxf.designpattern.template;

import java.sql.ResultSet;

/**
 * @author yinxf
 * @date 2020-04-28
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
