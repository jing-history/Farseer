package tk.jingzing.dao;

import org.apache.ibatis.annotations.Param;
import tk.jingzing.entity.User;

import java.util.List;

/**
 * @Description:数据查询
 * Created by Louis Wang on 2016/8/30.
 */

public interface UserDao {

    /**
     * 根据偏移量查询用户列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 增加积分
     */
    void addScore(int i);
}
