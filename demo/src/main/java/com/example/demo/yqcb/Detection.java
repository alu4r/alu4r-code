package com.example.demo.yqcb;

/**
 * @Description:
 * @author: lwg
 * @createTime: 2020年01月09日 17:02:00
 */

import lombok.Data;

/**daterange
 * 监测模型对象
 */
@Data
public class Detection {
    //检疫区域
    private String cord;
    //检疫申报单位名称
    private String monitorName;
    //检疫品种
    private String sampleName;
    //检疫对象
    private String diseaseName;

    //查询开始时间
    private String startTime;
    //查询结束时间
    private String endTime;
}
