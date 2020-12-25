package org.cc.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    @DubboReference
    private ATransferService aTransferService;
    @DubboReference
    private BTransferService bTransferService;
}
