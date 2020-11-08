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
    RequestDetailService requestDetailService;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository,
                              RequestDetailService requestDetailService) {
        this.requestRepository = requestRepository;
        this.requestDetailService = requestDetailService;
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
    public Map<Long, Integer> createGroupPurchaseMap(Request groupRequest) {
        Map<Long, Integer> requestStudents = new HashMap<>();

        for(RequestDetail requestDetail : groupRequest.getRequestDetails()) {
            if(!requestStudents.containsKey(requestDetail.getStudent().getUserId())) {
                requestStudents.put(requestDetail.getStudent().getUserId(), requestDetail.getCoolcoins());
            } else {
                requestStudents.put(requestDetail.getStudent().getUserId(),
                        requestStudents.get(requestDetail.getStudent().getUserId()) + requestDetail.getCoolcoins());
            }
        }
        return requestStudents;
    }

    @Override
    public void deleteRequestWithDetails(Request request) {
        List<RequestDetail> detailsList = request.getRequestDetails();

        for(RequestDetail requestDetail : request.getRequestDetails()) {
            requestDetail.setRequest(null);
            requestDetail.setStudent(null);
            requestDetailService.saveRequestDetail(requestDetail);
        }

        request.setGroup(null);
        request.setItemType(null);
        request.setRequestDetails(null);
        saveNewRequest(request);
        requestRepository.delete(request);

        for(RequestDetail requestDetail : detailsList) {
            requestDetailService.deleteRequestDetail(requestDetail);
        }
    }


//    @Override
//    public void deleteRecordsFromRequestDetailsList(List<RequestDetail> requestDetails) {
//        for(RequestDetail requestDetail : requestDetails) {
//            requestDetail.setRequest(null);
//            requestDetail.setStudent(null);
//            saveRequestDetail(requestDetail);
//            requestDetailRepository.delete(requestDetail);
//        }
//    }
}