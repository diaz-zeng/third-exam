package com.diaz.thirdexam.service.impl;

import com.diaz.thirdexam.dao.BillDao;
import com.diaz.thirdexam.dao.BillTypeDao;
import com.diaz.thirdexam.entity.Bill;
import com.diaz.thirdexam.entity.BillType;
import com.diaz.thirdexam.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.Set;

/**
 * @author Diaz
 * @since 2019/1/30 15:31
 */
public class BillServiceImpl implements BillService {

    @Autowired
    BillDao billDao;

    @Autowired
    BillTypeDao billTypeDao;

    PageRequest page;

    @Override
    public Set<Bill> findByDateBetween(Date start, Date end, Integer currentPage) {
        page = PageRequest.of(((currentPage - 1) * 25), 25, Sort.Direction.DESC);
        return billDao.findByDateBetween(start, end, page);
    }

    @Override
    public Set<Bill> findByDateBetweenAndType(Long typeId, Date start, Date end, Integer currentPage) {
        page = PageRequest.of(((currentPage - 1) * 25), 25, Sort.Direction.DESC);
        BillType billType = billTypeDao.getOne(typeId);
        return billDao.findByTypeAndDateBetween(billType, start, end, page);
    }
}
