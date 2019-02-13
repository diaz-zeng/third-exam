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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Diaz
 * @since 2019/1/30 15:23
 * 账单服务实现类
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillDao billDao;

    @Autowired
    BillTypeDao billTypeDao;

    @Override
    public List<BillType> getTypes() {
        return billTypeDao.findAll();
    }

    @Override
    public Page<Bill> findByDateBetween(Date start, Date end, Integer currentPage) throws DataNotFoundException {
        Page<Bill> result = billDao.findByDateBetween(start, end, PageUtils.getPageRequest(currentPage));
        if (result.hasContent()) {
            return result;
        } else {
            throw new DataNotFoundException();
        }
    }

    @Override
    public Page<Bill> findFullRole(Long typeId, Date start, Date end, Integer currentPage) throws IllegalDataException, DataNotFoundException {
        BillType billType = billTypeDao.getOne(typeId);
        if (typeId != null) {
            Page<Bill> result = billDao.findByTypeAndDateBetween(billType, start, end, PageUtils.getPageRequest(currentPage));
            if (result.hasContent()) {
                return result;
            } else {
                throw new DataNotFoundException();
            }

        } else {
            throw new IllegalDataException();
        }
    }

    @Override
    public Page<Bill> findByPage(Integer currentPage) throws DataNotFoundException {
        Page<Bill> result = billDao.findAll(PageUtils.getPageRequest(currentPage));
        if (result.hasContent()) {
            return result;
        } else {
            throw new DataNotFoundException();
        }
    }

    @Override
    public Page<Bill> findByType(Long typeId, Integer currentPage) throws DataNotFoundException, IllegalDataException {

        BillType billType = billTypeDao.getOne(typeId);
        if (billType != null) {
            Page<Bill> result = billDao.findByType(billType, PageUtils.getPageRequest(currentPage));
            if (result.hasContent()) {
                return result;
            } else {
                throw new DataNotFoundException();
            }
        } else {
            throw new IllegalDataException();
        }
    }

    @Transactional
    @Override
    public Boolean save(Bill bill) {
        return billDao.save(bill).getId() != null;
    }

    @Override
    public Page<Bill> generalSearch(Long typeId, Date start, Date end, Integer currentPage) throws IllegalDataException, DataNotFoundException {
        if (typeId != null) {
            if (start != null && end != null) {
                return findFullRole(typeId, start, end, currentPage);
            } else {
                return findByType(typeId, currentPage);
            }
        } else if (start != null && end != null) {
            return findByDateBetween(start, end, currentPage);
        } else {
            return findByPage(currentPage);
        }
    }

    @Override
    public BillType getType(Long typeId) {
        BillType billType = billTypeDao.findById(typeId).get();
        return billType;
    }
}
