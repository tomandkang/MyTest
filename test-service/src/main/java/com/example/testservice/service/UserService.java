package com.example.testservice.service;

import com.example.testapi.vo.MpUserVO;
import org.apache.ibatis.annotations.Param;

public interface UserService {



    MpUserVO getVOById(@Param("id") Long id);
}
