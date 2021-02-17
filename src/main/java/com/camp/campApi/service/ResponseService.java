package com.camp.campApi.service;

import com.camp.campApi.entity.AppUser;
import com.camp.campApi.entity.ErrorMessage;
import com.camp.campApi.entity.ResponseApi;

import java.util.List;

public interface ResponseService {

    public void saveResponse(ErrorMessage responseApi);

    public List<ErrorMessage> getAllResponse();


}
