package org.cc.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTAC;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    @DubboReference
    private ATransferService aTransferService;
    @DubboReference
    private BTransferService bTransferService;

    @HmilyTAC
    public void test(){
        aTransferService.transfer();
        bTransferService.transfer();
    }
}
