package com.diaz.thirdexam.service;

import com.diaz.thirdexam.entity.Bill;

import java.util.Date;
import java.util.Set;

/**
 * @author Diaz
 * @since 2019/1/30 15:23
 */
public interface BillService {

    public Set<Bill> findByDateBetween(Date start, Date end, Integer currentPage);

    public Set<Bill> findByDateBetweenAndType(Long typeId, Date start, Date end, Integer currentPage);
}
