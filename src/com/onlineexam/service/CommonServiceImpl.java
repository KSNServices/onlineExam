package com.onlineexam.service;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.CommonDAO;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private CommonDAO commonDAO;
    
    @Transactional
    @Override
    public Blob getBlob(byte[] is) {
        return commonDAO.getBlob(is);        
    }
}
