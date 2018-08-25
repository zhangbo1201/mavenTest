package cn.edu.hhit.dao;


import cn.edu.hhit.entity.TrainFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TestDao {
    List<TrainFile> getCount();
    int update(@Param(value = "id") String id, @Param("name") String name);
}
