package cn.edu.hhit.service;

import cn.edu.hhit.dao.TestDao;
import cn.edu.hhit.entity.TrainFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Override
    @Transactional
    public List<TrainFile> getCount() {
        return testDao.getCount();
    }

    @Override
    @Transactional
    public int update(String id, String user) {
        return testDao.update(id, user);
    }
}
