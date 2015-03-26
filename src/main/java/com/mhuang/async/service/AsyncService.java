package com.mhuang.async.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.mhuang.async.vo.AsyncResultVo;

/**
 * 异步Service
 * @author mhuang
 *  
 */
@Service
@Lazy(false)
@Async
public class AsyncService<T> {

    public void throwException() {
        throw new RuntimeException("error");
    }

    public AsyncResultVo<T> asyncGet1(AsyncResultVo<T> vo) {
        return vo;
    }

    //返回值必须是ListenableFuture/Future，因为是实现的问题（return ((AsyncListenableTaskExecutor) executor).submitListenable(task);）
    public ListenableFuture<AsyncResultVo<T>> asyncGet2(AsyncResultVo<T> vo) {
        return new AsyncResult<AsyncResultVo<T>>(vo);
    }

}
