package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.RequestDetail;

import java.util.List;

public interface RequestDetailService {
    void saveRequestDetail(RequestDetail newRequestDetail);
    void deleteRequestDetail(RequestDetail requestDetail);
}
