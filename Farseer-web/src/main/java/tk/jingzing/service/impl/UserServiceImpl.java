package tk.jingzing.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jingzing.dao.UserDao;
import tk.jingzing.entity.User;
import tk.jingzing.service.UserService;

import java.util.List;

/**
 * @Description:what to do
 * Created by Louis Wang on 2016/8/30.
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    public List<User> getUserList(int offset, int limit) {
        List<User> result_cache = userDao.queryAll(offset, limit);
        return result_cache;
    }
}
