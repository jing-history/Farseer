package tk.jingzing.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.jingzing.entity.User;
import tk.jingzing.service.UserService;

import java.util.List;

/**
 * @Description:用户
 * Created by Louis Wang on 2016/8/30.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, Integer offset, Integer limit) {
        logger.info("invoke----------/user/list");
        offset = offset == null ? 0 : offset;//
        limit = limit == null ? 50 : limit;//默认展示50条
        List<User> list = userService.getUserList(offset, limit);
        model.addAttribute("userlist", list);
        return "userlist";
    }
}
