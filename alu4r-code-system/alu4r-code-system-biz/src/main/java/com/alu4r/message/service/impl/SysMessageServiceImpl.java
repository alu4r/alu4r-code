package com.alu4r.message.service.impl;

import com.alu4r.common.core.system.base.service.impl.JeecgServiceImpl;
import com.alu4r.message.entity.SysMessage;
import com.alu4r.message.mapper.SysMessageMapper;
import com.alu4r.message.service.ISysMessageService;
import org.springframework.stereotype.Service;

/**
 * @Description: 消息
 * @Author: jeecg-boot
 * @Date:  2019-04-09
 * @Version: V1.0
 */
@Service
public class SysMessageServiceImpl extends JeecgServiceImpl<SysMessageMapper, SysMessage> implements ISysMessageService {

}
