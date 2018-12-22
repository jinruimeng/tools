package cn.smartGym.mapper;

import cn.smartGym.pojo.Baoming;
import cn.smartGym.pojo.BaomingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaomingMapper {
    long countByExample(BaomingExample example);

    int deleteByExample(BaomingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Baoming record);

    int insertSelective(Baoming record);

    List<Baoming> selectByExample(BaomingExample example);

    Baoming selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Baoming record, @Param("example") BaomingExample example);

    int updateByExample(@Param("record") Baoming record, @Param("example") BaomingExample example);

    int updateByPrimaryKeySelective(Baoming record);

    int updateByPrimaryKey(Baoming record);
}