package com.zhong.yygh.hosp.controller;

import com.zhong.yygh.common.result.R;
import com.zhong.yygh.model.acl.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author : zhong
 * @Description :
 * @create : 2022/10/26-22:31
 */
@RestController
@RequestMapping("/admin/user")
@CrossOrigin
public class UserController {

    @PostMapping("/login")
    public R login(@RequestBody User user){
        return R.ok().data("token","admin-token");
    }

    @GetMapping("/info")
    public R info(String token){
        return R.ok().data("roles","[admin]")
                .data("introduction","I am a super administrator")
                .data("avatar","https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.soogif.com%2F2yuV7GrH13xwmAy0Hc04REIWTQUwPEtW.gif&refer=http%3A%2F%2Fimg.soogif.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1655709239&t=1b2b2ba8571e6ae564c9febcf0600f3b")
                .data("name","Super Admin");
    }
}
