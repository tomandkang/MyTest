package com.example.testservice.controller.login;

import com.example.testapi.dto.UserDTO;
import com.example.testcommon.entity.Result;
import com.example.testservice.annotation.LogAnnotation;
import com.example.testservice.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenkangwen
 * @CreateTime: 2024-12-18  16:52
 * @Description:
 * @Version: 1.0
 */
@Slf4j
@RequestMapping(value = "/user")
@RestController
public class LoginController extends BaseController {

    @LogAnnotation
    @RequestMapping("/login/{id}")
    public Result test(@PathVariable("id") Long id) {
        log.info("请求参数：{}",id);
        Result<UserDTO> result = new Result<>();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setUserCode("okk");
        userDTO.setUserName("测试");
        result.setData(userDTO);
        return result;
    }

}
