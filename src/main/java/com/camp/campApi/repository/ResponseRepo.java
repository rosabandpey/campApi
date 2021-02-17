package com.camp.campApi.repository;

import com.camp.campApi.entity.ErrorMessage;
import com.camp.campApi.entity.ResponseApi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepo extends JpaRepository<ErrorMessage,Long> {
}
