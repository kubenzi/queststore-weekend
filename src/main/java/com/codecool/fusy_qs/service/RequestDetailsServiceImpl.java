package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.repository.RequestDetailsReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestDetailsServiceImpl implements RequestDetailsService {
    RequestDetailsReposiotry requestDetailsReposiotry;

    @Autowired
    public RequestDetailsServiceImpl(RequestDetailsReposiotry requestDetailsReposiotry) {
        this.requestDetailsReposiotry = requestDetailsReposiotry;
    }
}
