package com.diaz.thirdexam.service.impl;

import com.diaz.thirdexam.dao.BillDao;
import com.diaz.thirdexam.dao.BillTypeDao;
import com.diaz.thirdexam.entity.Bill;
import com.diaz.thirdexam.entity.BillType;
import com.diaz.thirdexam.exception.DataNotFoundException;
import com.diaz.thirdexam.exception.IllegalDataException;
import com.diaz.thirdexam.service.BillService;
import com.diaz.thirdexam.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

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
    public List<Bill> findByDateBetween(Date start, Date end, Integer currentPage) throws DataNotFoundException {
        List<Bill> content = billDao.findByDateBetween(start, end, PageUtils.getPageRequest(currentPage)).getContent();
        if (content != null && content.size() > 0) {
            return content;
        } else {
            throw new DataNotFoundException();
        }
    }

    @Override
    public List<Bill> findByDateBetweenAndType(Long typeId, Date start, Date end, Integer currentPage) throws IllegalDataException {
        BillType billType = billTypeDao.getOne(typeId);
        if (billType != null) {
            return billDao.findByTypeAndDateBetween(billType, start, end, PageUtils.getPageRequest(currentPage)).getContent();
        } else {
            throw new IllegalDataException();
        }
    }

    @Override
    public List<Bill> findByPage(Integer currentPage) throws DataNotFoundException {
        List<Bill> content = billDao.findAll(PageUtils.getPageRequest(currentPage)).getContent();
        if (content != null && content.size() > 0) {
            return content;
        } else {
            throw new DataNotFoundException();
        }
    }

}
