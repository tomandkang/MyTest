package com.example.testcommon.commom.eventListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @Author: chenkangwen
 * @CreateTime: 2024-12-19  16:04
 * @Description:
 * @Version: 1.0
 */
@Slf4j
@Component
public class EventListenerTest {


    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT,classes = OneEvent.class)
    @Order(0)
    public void testOneEventHandler(OneEvent event) {
        log.info("=====================OneEvent===================:{}",event.getName());
    }

    @Async
    @EventListener(classes = TwoEvent.class)
    @Order(0)
    public void twoEventEventHandler(TwoEvent event) {
        log.info("=====================TwoEvent===================:{}",event.getName());

    }


}
