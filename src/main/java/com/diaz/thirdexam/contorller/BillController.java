package com.diaz.thirdexam.contorller;

import com.diaz.thirdexam.entity.Bill;
import com.diaz.thirdexam.exception.DataNotFoundException;
import com.diaz.thirdexam.exception.IllegalDataException;
import com.diaz.thirdexam.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Diaz
 * @since 2019/1/30 15:45
 * 控制器
 */
@RestController
public class BillController {
    @Autowired
    BillService billService;

    /**
     * 定位到主页
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView gotoIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 定位到记账页
     *
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView gotoAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        return modelAndView;
    }

    /**
     * 初始化页面，请求账单类型信息
     *
     * @return
     */
    @RequestMapping("/initializePage")
    @PostMapping
    public Map<String, Object> initializePage() {
        Map<String, Object> map = new HashMap<>();
        map.put("types", billService.getTypes());
        return map;
    }

//    @RequestMapping("/getAll_page{currentPage}")
//    public Map<String, Object> initializePage(@PathVariable("currentPage") Integer currentPage) throws DataNotFoundException {
//        Map<String, Object> map = new HashMap<>(0);
//        Page<Bill> byPage = billService.findByPage(currentPage);
//        map.put("rows", byPage.getContent());
//        map.put("totalPage", byPage.getTotalPages());
//        map.put("types", billService.getTypes());
//        return map;
//    }

    /**
     * 查询数据
     *
     * @param currentPage
     * @param typeSelect
     * @param start
     * @param end
     * @return
     */
    @RequestMapping("/doSearch_page{page}")
    public Map<String, Object> search(@PathVariable("page") Integer currentPage, Long typeSelect, @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        Map<String, Object> map = new HashMap<>(0);
        try {
            Page<Bill> byPage = null;

            byPage = billService.generalSearch(typeSelect, start, end, currentPage);

            map.put("rows", byPage.getContent());
            map.put("totalPage", byPage.getTotalPages());
            map.put("currentPage", byPage.getPageable().getPageNumber());
        } catch (Exception e) {
            map.put("errorMsg", e.getMessage());
        } finally {
            return map;
        }
    }

    /**
     * 添加一条记录
     *
     * @param type
     * @param price
     * @param info
     * @param date
     * @param title
     * @return
     */
    @RequestMapping("/addOne")
    @PostMapping
    public Map<String, Object> add(Long type, Float price, String info, @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, String title) {
        Map<String, Object> map = new HashMap<>(0);
        Bill bill = new Bill();
        bill.setDate(date);
        bill.setExplain(info);
        bill.setPrice(price);
        bill.setTitle(title);
        bill.setType(billService.getType(type));
        if (billService.save(bill)) {
            map.put("result", "success");
        } else {
            map.put("result", "error");
        }

        return map;
    }
}
