package com.wwh.whblog.module.shiro;

import com.wwh.whblog.module.sys.entity.User;
import com.wwh.whblog.module.sys.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MyRealm extends AuthorizingRealm {
    private static Logger logger = LogManager.getLogger(MyRealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("AuthorizationInfo initializing 权限验证...");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("AuthenticationInfo initializing 身份验证...");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userService.getUserByUserName(token.getUsername());
        if(user == null){
            logger.error("用户【" + token.getUsername() + "】不存在！");
            throw new AccountException("用户不存在！");
        }
        if(User.IS_LOCK.equals(user.getIsLock())){
            logger.error("用户【" + token.getUsername() + "】已被锁定！");
            throw new DisabledAccountException("用户已被锁定！");
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }

    @PostConstruct
    public void initCredentialsMatcher() {
        //该句作用是重写shiro的密码验证，让shiro用我自己的验证
        setCredentialsMatcher(new CredentialsMatcher());

    }
}
