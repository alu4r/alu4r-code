package com.alu4r.system.modules.api.fallback;

import com.alu4r.common.core.system.vo.SysUserCacheInfo;
import com.alu4r.common.core.vo.Result;
import com.alu4r.system.modules.api.SysUserRemoteApi;
import com.alu4r.system.modules.system.entity.SysPermission;
import com.alu4r.system.modules.system.entity.SysPermissionDataRule;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @author scott
 * @date 2020/05/22
 */
@Slf4j
@Component
public class SysUserRemoteApiFallbackImpl implements SysUserRemoteApi {
	@Setter
	private Throwable cause;


	@Override
	public Result<Set<String>> getUserRolesSet(String username) {
		log.error("获取用户角色集合 {}",username, cause);
		return null;
	}

	@Override
	public Result<Set<String>> getUserPermissionsSet(String username) {
		log.error("获取用户权限集合 {}",username, cause);
		return null;
	}

	@Override
	public List<SysPermission> queryComponentPermission(String component) {
		return null;
	}

	@Override
	public List<SysPermission> queryRequestPermission(String method, String path) {
		return null;
	}

	@Override
	public List<SysPermissionDataRule> queryUserDataRule(String username, String permissionId) {
		return null;
	}

	@Override
	public SysUserCacheInfo getCacheUser(String username) {
		return null;
	}
}