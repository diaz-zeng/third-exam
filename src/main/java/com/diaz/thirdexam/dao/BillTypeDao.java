package com.diaz.thirdexam.dao;

import com.diaz.thirdexam.entity.BillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author Diaz
 * @since 2019/1/30 15:01
 * 账单类型持久化层
 */
public interface BillTypeDao extends JpaRepository<BillType, Long>, JpaSpecificationExecutor<BillType> {
}
