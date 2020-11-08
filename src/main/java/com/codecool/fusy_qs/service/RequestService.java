package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Request;
import com.codecool.fusy_qs.entity.RequestDetail;
import com.codecool.fusy_qs.entity.Student;

import java.util.List;
import java.util.Map;

public interface RequestService {
    List<Request> getCurrentGroupRequests(Long groupId);
    void saveNewRequest(Request newRequest);
    Request findRequestById(Long requestId);
    int calculateTotalContribution(Request request);
    boolean isCompleted(Request request);
    Map<Long, Integer> createGroupPurchaseMap(Request groupRequest);
    void deleteRequestWithDetails(Request request);
}
