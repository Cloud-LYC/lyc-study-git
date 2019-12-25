package com.lyc.study.mapTest;

import com.lyc.dto.UserDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/9/23
 * @time: 16:23
 * @desc:
 */
public class MapTestLyc {
    public static void main(String[] args) {
        Map<Integer, UserDTO> userDTOMap = new HashMap<>();

        userDTOMap.put(1, UserDTO.builder().userId(1).build());
        userDTOMap.put(1, UserDTO.builder().userId(2).build());
        userDTOMap.put(2, UserDTO.builder().userId(1).build());

        List<UserDTO> resultList = new ArrayList<>(userDTOMap.values());


        resultList.sort((o1, o2) -> o1.getUserId() - o2.getUserId() > 0 ? 1 : -1);

        System.out.println(userDTOMap);

    }
}
