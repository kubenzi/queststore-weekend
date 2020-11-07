package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Request;
import com.codecool.fusy_qs.entity.RequestDetail;
import com.codecool.fusy_qs.entity.Student;
import com.codecool.fusy_qs.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequestServiceImpl implements RequestService {
    RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<Request> getCurrentGroupRequests(Long groupId) {
        return requestRepository.getRequestsByGroupId(groupId);
    }

    @Override
    public void saveNewRequest(Request newRequest) {
        requestRepository.save(newRequest);
    }

    @Override
    public Request findRequestById(Long requestId) {
        return requestRepository.findById(requestId).orElse(null);
    }

    @Override
    public int calculateTotalContribution(Request request) {
        int totalContribution = 0;

        for(RequestDetail detail : request.getRequestDetails()) {
            totalContribution += detail.getCoolcoins();
        }

        return totalContribution;
    }

    @Override
    public boolean isCompleted(Request request) {
        return calculateTotalContribution(request) == request.getItemCost();
    }

    @Override
    public Map<Student, Integer> createGroupPurchaseMap(Request groupRequest) {
        Map<Student, Integer> requestStudents = new HashMap<>();

        for(RequestDetail requestDetail : groupRequest.getRequestDetails()) {
            if(!requestStudents.containsKey(requestDetail.getStudent())) {
                requestStudents.put(requestDetail.getStudent(), requestDetail.getCoolcoins());
            } else {

            }
        }
        return requestStudents;
    }

}