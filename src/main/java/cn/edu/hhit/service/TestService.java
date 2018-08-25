package cn.edu.hhit.service;

import cn.edu.hhit.entity.TrainFile;

import java.util.List;
public interface TestService {
    List<TrainFile> getCount();
    int update(String id,String user);
}
