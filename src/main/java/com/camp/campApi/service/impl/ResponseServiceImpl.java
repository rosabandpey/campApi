package com.camp.campApi.service.impl;

import com.camp.campApi.entity.ErrorMessage;
import com.camp.campApi.entity.ResponseApi;
import com.camp.campApi.repository.ResponseRepo;
import com.camp.campApi.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    ResponseRepo responseRepo;


    @Override
    public void saveResponse(ErrorMessage errorMessage) {

        responseRepo.save(errorMessage);

    }

    @Override
    public List<ErrorMessage> getAllResponse() {

        List reponses=responseRepo.findAll();
        return reponses;
    }
}
