package com.alu4r.system.service;

import com.alu4r.system.modules.system.entity.SysAnnouncementSend;
import com.alu4r.system.modules.system.model.AnnouncementSendModel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 用户通告阅读标记表
 * @Author: jeecg-boot
 * @Date:  2019-02-21
 * @Version: V1.0
 */
public interface ISysAnnouncementSendService extends IService<SysAnnouncementSend> {

	public List<String> queryByUserId(String userId);
	
	/**
	 * @功能：获取我的消息
	 * @param announcementSendModel
	 * @return
	 */
	public Page<AnnouncementSendModel> getMyAnnouncementSendPage(Page<AnnouncementSendModel> page, AnnouncementSendModel announcementSendModel);

}
