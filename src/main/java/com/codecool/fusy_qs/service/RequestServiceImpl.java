package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Request;
import com.codecool.fusy_qs.entity.RequestDetail;
import com.codecool.fusy_qs.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
