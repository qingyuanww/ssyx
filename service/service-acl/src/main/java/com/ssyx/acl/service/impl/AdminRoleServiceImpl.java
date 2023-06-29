package com.ssyx.acl.service.impl;

import com.ssyx.acl.mapper.AdminRoleMapper;
import com.ssyx.acl.service.AdminRoleService;
import com.ssyx.model.acl.AdminRole;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
}
