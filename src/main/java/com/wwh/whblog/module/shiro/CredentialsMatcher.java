package com.wwh.whblog.module.shiro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.util.DigestUtils;

/**
 * 密码校验器
 *
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {
    private static Logger logger = LogManager.getLogger(CredentialsMatcher.class);

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        logger.info("CredentialsMatcher.doCredentialsMatch ... ");
        UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
        Object tokenCredentials = DigestUtils.md5DigestAsHex((authcToken.getUsername() + authcToken.getPassword()).getBytes());
        Object accountCredentials = getCredentials(info);
        return accountCredentials.equals(tokenCredentials);
    }

}
