package com.lyc.study.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/5/15
 * @time: 15:45
 * @desc:
 */
public class TestJson {

    public static void main(String[] args) {
        String source = "{\"workflowStatus\":{\"abroad\":0,\"addUser\":\"20094364\",\"address\":\"淞虹路660号\",\"createTime\":1557816411000,\"detailCode\":\"S00001\",\"dpId\":130328905,\"flowId\":193859415,\"flowType\":7,\"isAppeal\":0,\"lastProcType\":\"createShop\",\"mtId\":141434468,\"operationType\":2,\"organization\":\"DIANPING\",\"phone\":\"\",\"poiId\":160057009,\"procList\":[{\"createTime\":1557904135471,\"procId\":160057009,\"procStatus\":1,\"procType\":\"notify\",\"reason\":\"final success\",\"result\":\"success\",\"updateTime\":1557904135485}],\"procType\":\"notify\",\"reason\":\"{\\\"info\\\":[\\\"success\\\"]}\",\"role\":1,\"shopName\":\"王小二的烧烤店\",\"source\":\"DIANPING\",\"sourceCode\":\"00000001\",\"stage\":\"success\",\"subSource\":\"BGC\",\"updateTime\":1557904135186},\"sendTime\":1557904135487}";

        JSONObject jsonObject = JSON.parseObject(source);
        Integer dpShopId = Integer.valueOf(jsonObject.getJSONObject("workflowStatus").getString("dpId"));

        System.out.println("23333");

    }
}
