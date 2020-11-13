package com.example.demo.yqcb;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.util.UriComponentsBuilder;
import sun.net.www.http.HttpClient;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 电子出证疫病测报接口测试
 * @author: alu4r
 * @date: 2020/11/12 21:00
 */
public class YqcbMain {
    public static void main(String[] args) {
        Map<String, Object> paramsMap = new HashMap<>();
        Detection detection = new Detection();
        detection.setMonitorName("江苏");
        handlePublic(paramsMap, detection);
        paramsMap.put("NID", Base64Utils.encodeBase64("xxxxxxxx"));
        String url = "http://znyj.nftec.agri.cn:8084/api/ZXJCDataReported/GetZXJCDiseaseReported";
        String jsonResult = HttpUtil.get(url, paramsMap);
        Map<String, String> map = JSONUtil.parseObj(jsonResult).toBean(Map.class);
        String data = Base64Utils.decodeBase64(map.get("data"));
        System.out.println(data);
    }

    private static void handlePublic(Map<String, Object> paramsMap, Detection detection){
        paramsMap.put("ExpDate", DateUtil.offsetDay(new Date(), 1).toDateStr());
        paramsMap.put("ReferUrl", "");
        paramsMap.put("Cord", Base64Utils.encodeBase64(detection.getCord()));
        paramsMap.put("MonitorName", Base64Utils.encodeBase64(detection.getMonitorName()));
        paramsMap.put("SampleName", Base64Utils.encodeBase64(detection.getSampleName()));
        paramsMap.put("DiseaseName", Base64Utils.encodeBase64(detection.getDiseaseName()));
        if (StrUtil.isNotEmpty(detection.getStartTime())) {
            paramsMap.put("startTime", Base64Utils.encodeBase64(detection.getStartTime()));
        } else {
            paramsMap.put("startTime", "");
        }
        if (StrUtil.isNotEmpty(detection.getEndTime())) {
            paramsMap.put("EndTime", Base64Utils.encodeBase64(detection.getEndTime()));
        } else {
            paramsMap.put("EndTime","");
        }
    }
}
