package com.example.demo.commom.constant;

import cn.hutool.core.lang.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * @Description 公共常量
 * @Author zengzheng
 * @Date 2020/5/19 10:40
 */
public interface CommonConstant {
    interface JsonTypeReference {
        /**
         * Json字符串转换成Map<String, List<Map<String, Object>>>格式
         */
        TypeReference<Map<String, List<Map<String, Object>>>> MAP_LIST_MAP = new TypeReference<Map<String, List<Map<String, Object>>>>() {
        };
        TypeReference<Map<String, Object>> MAP = new TypeReference<Map<String, Object>>() {
        };

        TypeReference<List<Map<String, Object>>> LIST_MAP = new TypeReference<List<Map<String, Object>>>() {
        };
        TypeReference<List<String>> LIST_STRING = new TypeReference<List<String>>() {
        };
    }

    interface RequestInfo {
        String REQUESTID = "requestId";
        String OPERATOR = "operator";
    }


    String SYSTEM = "system";
    String EXCEL_DOWNLOAD_FILE_PATH = "/opt/yks/files/crmmgr/excel/out/";

    String FILE_DIRECTORY = "/opt/tmp/";
    String FILE_UPLOAD_GETAWAY = "http://www.soter.youkeshu.com/yks/file/server/";

    Integer SUCCESS_CODE = 200;
    Integer FAIL_CODE = 500;
    String SUCCESS = "success";
    String FAILURE = "fail";

    String SUCCESS_CN = "成功";
    String FAILURE_CN = "失败";
    String YES_CN = "是";
    String NO_CN = "否";

    Integer ALL_ACOUNT = 1;

    String MAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    String PHONE_REGEX = "^1[3456789]\\d{9}$";
}
