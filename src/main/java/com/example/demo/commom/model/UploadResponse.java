package com.example.demo.commom.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/15 18:42
 * @description
 */
@NoArgsConstructor
@Data
public class UploadResponse implements Serializable {
    private static final long serialVersionUID = -4199274535848984064L;

    @JSONField(name = "state")
    private String state;
    @JSONField(name = "msg")
    private String msg;
    @JSONField(name = "data")
    private List<DataDTO> data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "filename")
        private String filename;
        @JSONField(name = "extension")
        private String extension;
        @JSONField(name = "contentType")
        private String contentType;
        @JSONField(name = "path")
        private String path;
        @JSONField(name = "awsPath")
        private String awsPath;
        @JSONField(name = "cnPath")
        private String cnPath;
        @JSONField(name = "size")
        private Integer size;
    }
}
