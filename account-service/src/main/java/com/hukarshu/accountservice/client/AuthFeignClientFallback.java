package com.hukarshu.accountservice.client;

import com.hukarshu.accountservice.domain.User;
import net.bytebuddy.asm.Advice;
import org.aspectj.apache.bcel.classfile.Unknown;
import org.omg.CORBA.portable.UnknownException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @Auther: hunan
 * @Date: 04/05/2019 15:30
 * @Description:
 */
@Component
public class AuthFeignClientFallback implements AuthFeignClient {
    private static final Logger Log = LoggerFactory.getLogger(AuthFeignClientFallback.class);

    @Override
    public void createUser(User user){
        Log.error("Create user {} failed!",user.getUsername());
        Assert.notNull(null,"createUser fails！");
    }
}
