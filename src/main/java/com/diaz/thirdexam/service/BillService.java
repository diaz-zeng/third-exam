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
 * 账单服务接口
 */
public interface BillService {

    /**
     * 获取全部账单类型
     * @return
     */
    List<BillType> getTypes();

    /**
     * 按时间间隔查询账单
     * @param start
     * @param end
     * @param currentPage
     * @return
     * @throws DataNotFoundException
     */
    Page<Bill> findByDateBetween(Date start, Date end, Integer currentPage) throws DataNotFoundException;

    /**
     * 按时间和类型查找账单
     * @param typeId
     * @param start
     * @param end
     * @param currentPage
     * @return
     * @throws IllegalDataException
     * @throws DataNotFoundException
     */
    Page<Bill> findFullRole(Long typeId, Date start, Date end, Integer currentPage) throws IllegalDataException, DataNotFoundException;

    /**
     * 分页查找全部账单
     * @param currentPage
     * @return
     * @throws DataNotFoundException
     */
    Page<Bill> findByPage(Integer currentPage) throws DataNotFoundException;

    /**
     * 按类型查找
     * @param typeId
     * @param currentPage
     * @return
     * @throws DataNotFoundException
     * @throws IllegalDataException
     */
    Page<Bill> findByType(Long typeId, Integer currentPage) throws DataNotFoundException, IllegalDataException;

    /**
     * 保存一个
     * @param bill
     * @return
     */
    Boolean save(Bill bill);

    /**
     * 通用查询
     * @param typeId
     * @param start
     * @param end
     * @param currentPage
     * @return
     * @throws IllegalDataException
     * @throws DataNotFoundException
     */
    Page<Bill> generalSearch(Long typeId, Date start, Date end, Integer currentPage) throws IllegalDataException, DataNotFoundException;

    /**
     * 按id获取一个类型
     * @param typeId
     * @return
     */
    BillType getType(Long typeId);

}
