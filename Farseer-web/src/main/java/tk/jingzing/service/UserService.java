package tk.jingzing.service;

import tk.jingzing.entity.User;

import java.util.List;

/**
 * @Description:what to do
 * Created by Louis Wang on 2016/8/30.
 */

public interface UserService {

    List<User> getUserList(int offset, int limit);
}
