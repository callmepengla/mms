package com.fms.mms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


import com.fms.mms.dao.ClassTableDao;
import com.fms.mms.entity.ClassTableEntity;
import com.fms.mms.service.ClassTableService;


@Service("classTableService")
public class ClassTableServiceImpl extends ServiceImpl<ClassTableDao, ClassTableEntity> implements ClassTableService {

}
