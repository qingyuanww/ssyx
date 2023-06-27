package com.ssyx.acl.controller;

import com.ssyx.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: oywl
 * @time: 2023-6-26 23:31
 */
@Api(tags = "测试接口")
@RestController
@RequestMapping("/api/acl/index")
@CrossOrigin //跨域
public class ApiController {
    @ApiOperation("测试")
    @PostMapping("/login")
    public Result login() {
        //返回token值
        Map<String,String> map = new HashMap<>();
        map.put("token","token-admin");
        return Result.ok(map);
    }
}
