package com.diaz.thirdexam.dao;

import com.diaz.thirdexam.entity.Bill;
import com.diaz.thirdexam.entity.BillType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

/**
 * @author Diaz
 * @since 2019/1/30 15:01
 */
@Repository
public interface BillDao extends JpaRepository<Bill, Long>, JpaSpecificationExecutor<Bill> {
    Set<Bill> findByTypeAndDateBetween(BillType type, Date start, Date end, PageRequest pageRequest);

    Set<Bill> findByDateBetween(Date start, Date end, PageRequest pageRequest);
}
