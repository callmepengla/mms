package com.fms.mms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.fms.mms.dao.SysDictDao;
import com.fms.mms.entity.SysDictEntity;
import com.fms.mms.service.SysDictService;


@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictEntity> implements SysDictService {

}
