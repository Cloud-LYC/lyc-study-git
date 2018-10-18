package com.lyc.study.collection.set;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liyuanchi
 * @Description:
 * @Date: 15:11 2017/12/21
 */
public class MyTest {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();


        for (int i = 1; i < 11; i++) {
            User user = new User();
            user.setUserName("LYC"+i);
            user.setAge(i);
            userList.add(user);
        }

        User addUser = new User();

        List<User> cacheUser = new ArrayList<>();
        for (User jiUser : userList
             ) {
            if (jiUser.getAge() / 2 == 0){
                addUser = jiUser;
                cacheUser.add(jiUser);
                for (User user: userList
                     ) {
                    if (!user.getUserName().equals(addUser.getUserName()) && user.getAge() < 6){
                        addUser.setAge(addUser.getAge()+user.getAge());
                        cacheUser.add(user);
                    }
                }
            }

        }

        userList.removeAll(cacheUser);
        userList.add(addUser);


        for (User u : userList
                ) {
            System.out.println(u);
        }

    }
}
