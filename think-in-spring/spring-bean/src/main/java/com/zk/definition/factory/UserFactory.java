package com.zk.definition.factory;/**
 * Created by dzk on 2020/4/4.
 */

import com.zk.ioc.domain.User;

/**
 * @ClassName UserFactory
 * @Description
 * @Author dzk
 * @Version v1
 * @Date 2020/4/4
 **/
public interface UserFactory {

    default User createUser() {
        return User.createUsrer();
    }
}
