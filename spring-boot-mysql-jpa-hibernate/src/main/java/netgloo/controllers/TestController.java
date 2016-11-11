package netgloo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import netgloo.dao.UserRepository;
import netgloo.models.User;

@RestController
@RequestMapping("/select")
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/find")
    public List<User> getUserList(){
        logger.info("从数据库读取User集合");
        // 测试更新数据库
        logger.info("更新的行数：" + userRepository.getList());
        //userRepository.delete(23);

        return userRepository.getList();
    }
}
