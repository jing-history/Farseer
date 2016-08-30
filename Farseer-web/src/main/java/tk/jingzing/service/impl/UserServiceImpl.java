package tk.jingzing.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jingzing.cache.RedisCache;
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

    @Autowired
    private RedisCache cache;

    @Override
    public List<User> getUserList(int offset, int limit) {
        String cache_key=RedisCache.CAHCENAME+"|getUserList|"+offset+"|"+limit;
        //先去缓存中取
        List<User> result_cache=cache.getListCache(cache_key, User.class);
        if(result_cache==null){
            //缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
            result_cache=userDao.queryAll(offset, limit);
            cache.putListCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
            logger.info("put cache with key:"+cache_key);
        }else{
            logger.info("get cache with key:"+cache_key);
        }
        return result_cache;
    }
}
