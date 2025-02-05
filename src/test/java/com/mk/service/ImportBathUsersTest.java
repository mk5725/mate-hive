package com.mk.service;

import com.mk.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/*批量插入用户信息*/
@SpringBootTest
public class ImportBathUsersTest {

    @Autowired
    private UserService userService;

    /**
     * 批量插入
     */
    @Test
    void testBathImportUser(){
        StopWatch watch = new StopWatch();
        watch.start();
//        Long INSERT_NUM = 10000000L;
        Long INSERT_NUM = 1000000L;
        List<User> userList = new ArrayList<>(100);
        for (Long i = 0L; i < INSERT_NUM; i++) {
            User user = User.builder()
                    .username("user" + i)
                    .userAccount("user" + i)
                    .gender(0)
                    .avatarUrl("https://thirdwx.qlogo.cn/mmopen/vi_32/3ic5TFH1icSe64R7EwoUIwqqNicnzvia3xfF08qFKoqannxDoBdcg/132")
                    .email("abcde" + i + "@gmail.com")
                    .phone("12345678" + i)
                    .userPassword("1442de8d3dfff7f35f2a5f7c108b02b6")
                    .planetCode("1234" + i)
                    .tags("[\"java\", \"emo\", \"打工中\", \"emo\", \"打工中\"]")
                    .build();
            userList.add(user);
//            批量插入10条数据
            if (userList.size() == 100) {
                userService.saveBatch(userList);
                userList.clear();
            }
        }
        watch.stop();
        System.out.println("批量插入执行时间(ms)：" + watch.getTotalTimeMillis());
    }

    /**
     * 逐条插入
     */
    @Test
    void testImportUser(){
        StopWatch watch = new StopWatch();
        watch.start();
//        Long INSERT_NUM = 10000000L;
        Long INSERT_NUM = 10000L;
        for (Long i = 0L; i < INSERT_NUM; i++) {
            User user = User.builder()
                    .username("user" + i)
                    .userAccount("user" + i)
                    .gender(0)
                    .avatarUrl("https://thirdwx.qlogo.cn/mmopen/vi_32/3ic5TFH1icSe64R7E7cIrAlkgtTGtGHbv6LfrE3Ue3C9KJojkiaKkZLwoUIwqqNicnzvia3xfF08qFKoqannxDoBdcg/132")
                    .email("abcde" + i + "@gmail.com")
                    .phone("12345678" + i)
                    .userPassword("1442de8d3dfff7f35f2a5f7c108b02b6")
                    .planetCode("1234" + i)
                    .tags("[\"java\", \"emo\", \"打工中\", \"emo\", \"打工中\"]")
                    .build();
            userService.save(user);
        }
        watch.stop();
        System.out.println("逐条插入执行时间(ms)：" + watch.getTotalTimeMillis());
    }
}
