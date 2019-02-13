package com.diaz.thirdexam.dao;

import com.diaz.thirdexam.entity.Bill;
import com.diaz.thirdexam.entity.BillType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author Diaz
 * @since 2019/1/30 15:01
 * 账单持久化层
 */
@Repository
public interface BillDao extends JpaRepository<Bill, Long>, JpaSpecificationExecutor<Bill> {

    Page<Bill> findByTypeAndDateBetween(BillType type, Date start, Date end, Pageable pageable);

    Page<Bill> findByDateBetween(Date start, Date end, Pageable pageable);

    Page<Bill> findByType(BillType type, Pageable pageable);

}
