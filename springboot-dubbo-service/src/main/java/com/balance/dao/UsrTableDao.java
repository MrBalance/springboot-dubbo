package com.balance.dao;

import com.balance.model.UsrTable;
import com.balance.model.UsrTableExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UsrTableDao {
    long countByExample(UsrTableExample example);

    int deleteByExample(UsrTableExample example);

    int deleteByPrimaryKey(Integer usrId);

    int insert(UsrTable record);

    int insertSelective(UsrTable record);

    List<UsrTable> selectByExample(UsrTableExample example);

    UsrTable selectByPrimaryKey(Integer usrId);

    int updateByExampleSelective(@Param("record") UsrTable record, @Param("example") UsrTableExample example);

    int updateByExample(@Param("record") UsrTable record, @Param("example") UsrTableExample example);

    int updateByPrimaryKeySelective(UsrTable record);

    int updateByPrimaryKey(UsrTable record);
}