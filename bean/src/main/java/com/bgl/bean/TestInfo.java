package com.bgl.bean;

import java.util.List;

/**
 * Created by 包国梁 on 2020/6/2.
 */
public class TestInfo {
    public String status;
    public List<DataInfo> datas;
    public class DataInfo{
        public String thumbnail;
        public String title;
        public String author;
        public String description;
    }
}
