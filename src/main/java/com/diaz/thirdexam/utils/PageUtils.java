package com.diaz.thirdexam.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageUtils {
    public static PageRequest getPageRequest(Integer page) {
        return PageRequest.of(page, 25, Sort.by(Sort.Direction.DESC, "date"));
    }

}
