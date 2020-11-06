package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Request;

import java.util.List;

public interface RequestService {
    List<Request> getCurrentGroupRequests(Long groupId);
    void saveNewRequest(Request newRequest);
    Request findRequestById(Long requestId);
}
