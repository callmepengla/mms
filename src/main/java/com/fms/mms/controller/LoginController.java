package com.fms.mms.controller;

import com.fms.mms.dto.LoginDTO;
import com.fms.mms.entity.SysUserEntity;
import com.fms.mms.exception.MtsException;
import com.fms.mms.service.SysUserService;
import com.fms.mms.service.SysUserTokenService;
import com.fms.mms.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录
 * @author admin
 */
@RestController
@RequestMapping("user")
@CrossOrigin
@Api(tags = "登陆管理")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserTokenService sysUserTokenService;

    @PostMapping("login")
    @ApiOperation(value = "登录")
    public R login(HttpServletRequest request, @RequestBody LoginDTO login){
        //用户信息
        SysUserEntity userEntity = sysUserService.getByUserName(login.getUsername());
        //用户不存在
        if (userEntity == null){
            throw new MtsException("账号不存在！请联系管理员！");
        }

        //密码错误
        if (!login.getPassword().equals(userEntity.getPassword())){
            throw new MtsException("密码输入错误！请重新输入！");
        }

        //登录成功
        return sysUserTokenService.createToken(userEntity.getId());
    }

    @GetMapping("info")
    public R info(){
        return R.ok().data("roles","[admin]")
                .data("name","admin")
                .data("avatar","https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1173369790,227754684&fm=26&gp=0.jpg");
    }

    @PostMapping("logout")
    @ApiOperation(value = "退出")
    public R logout(HttpServletRequest request) {

        return R.ok();
    }
}
