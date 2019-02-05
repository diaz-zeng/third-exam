package com.diaz.thirdexam.service;

import com.diaz.thirdexam.entity.Bill;
import com.diaz.thirdexam.entity.BillType;
import com.diaz.thirdexam.exception.DataNotFoundException;
import com.diaz.thirdexam.exception.IllegalDataException;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * @author Diaz
 * @since 2019/1/30 15:23
 */
public interface BillService {

    List<BillType> getTypes();

    Page<Bill> findByDateBetween(Date start, Date end, Integer currentPage) throws DataNotFoundException;

    Page<Bill> findFullRole(Long typeId, Date start, Date end, Integer currentPage) throws IllegalDataException, DataNotFoundException;

    Page<Bill> findByPage(Integer currentPage) throws DataNotFoundException;

    Page<Bill> findByType(Long typeId, Integer currentPage) throws DataNotFoundException, IllegalDataException;

    Boolean save(Bill bill);

    Page<Bill> generalSearch(Long typeId, Date start, Date end, Integer currentPage) throws IllegalDataException, DataNotFoundException;

    BillType getType(Long typeId);

}
