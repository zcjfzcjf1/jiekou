package com.neo.web;

import com.neo.entity.RestSResponse;
import com.neo.entity.User;
import com.neo.inter.AccessRequired;
import com.neo.service.UserService;
import com.neo.util.testUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {


    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;
    @Autowired
    testUtil testUtil;


    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/list";
    }


    @RequestMapping("/login")
    @ResponseBody
    public RestSResponse login(User user) {
        RestSResponse rs=new RestSResponse();
        userService.findUserByUserNameAndPassword(user.getUserName(), user.getPassword(),rs);
        return rs;
    }


    @RequestMapping("/test")
    @ResponseBody
    // @AccessRequired(resoName="getList")
    public RestSResponse test( ) throws Exception {
        RestSResponse rs=new RestSResponse();
        rs.setData(1);
        testUtil.test();
        return rs;
    }



}


