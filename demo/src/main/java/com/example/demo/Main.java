package com.example.demo;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/11/8 0:01
 */
public class Main {
    public static void main(String[] args) {
        String json = "{\"employee\":{ \"name\":\"Bill Gates\", \"age\":\"62\", \"city\":\"Seattle\"}}";
        JSONObject jsonObject = JSONUtil.parseObj(json);
        JSONObject employee = JSONUtil.parseObj(jsonObject.getByPath("employee").toString());
        employee.getConfig().setOrder(true);
        System.out.println(employee.toStringPretty());
        int minValue = Integer.MIN_VALUE;
    }
}
