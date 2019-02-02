package com.diaz.thirdexam;

import com.diaz.thirdexam.dao.BillDao;
import com.diaz.thirdexam.entity.Bill;
import com.diaz.thirdexam.entity.BillType;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThirdExamApplication.class)
public class ThirdExamApplicationTests {

    @Autowired
    BillDao billDao;

    @Test
    public void contextLoads() {

        Page<Bill> bills = billDao.findAll(PageRequest.of(4, 2, Sort.by(Sort.Direction.DESC, "date")));

        System.out.println(bills.getTotalPages());

        System.out.println(bills.nextPageable());

        bills.getContent().forEach(System.out::println);
    }

}

