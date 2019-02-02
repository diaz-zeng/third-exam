package com.diaz.thirdexam.service;

import com.diaz.thirdexam.entity.Bill;
import com.diaz.thirdexam.exception.DataNotFoundException;
import com.diaz.thirdexam.exception.IllegalDataException;

import java.util.Date;
import java.util.List;

/**
 * @author Diaz
 * @since 2019/1/30 15:23
 */
public interface BillService {

    List<Bill> findByDateBetween(Date start, Date end, Integer currentPage) throws DataNotFoundException;

    List<Bill> findByDateBetweenAndType(Long typeId, Date start, Date end, Integer currentPage) throws IllegalDataException;

    List<Bill> findByPage(Integer Page) throws DataNotFoundException;
}
