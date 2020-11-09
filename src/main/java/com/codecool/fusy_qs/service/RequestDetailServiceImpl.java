package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.RequestDetail;
import com.codecool.fusy_qs.repository.RequestDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestDetailServiceImpl implements RequestDetailService {
        RequestDetailRepository requestDetailRepository;

    public RequestDetailServiceImpl(RequestDetailRepository requestDetailRepository) {
        this.requestDetailRepository = requestDetailRepository;
    }

    @Override
    public void saveRequestDetail(RequestDetail newRequestDetail) {
        requestDetailRepository.save(newRequestDetail);
    }

    @Override
    public void deleteRequestDetail(RequestDetail requestDetail) {
        requestDetailRepository.delete(requestDetail);
    }
}
