package com.study.chat.global.config

import com.study.chat.member.domain.MemberRole.MEMBER
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import org.springframework.messaging.simp.SimpMessageType.MESSAGE
import org.springframework.messaging.simp.SimpMessageType.SUBSCRIBE
import org.springframework.security.authorization.AuthorizationManager
import org.springframework.security.config.annotation.web.socket.EnableWebSocketSecurity
import org.springframework.security.messaging.access.intercept.MessageMatcherDelegatingAuthorizationManager

@Configuration
@EnableWebSocketSecurity
class WebSocketSecurityConfig {
    @Bean
    fun messageAuthorizationManager(messages: MessageMatcherDelegatingAuthorizationManager.Builder): AuthorizationManager<Message<*>> =
        messages
            .nullDestMatcher().authenticated()
            .simpSubscribeDestMatchers("/user/queue/errors").permitAll()
            .simpDestMatchers("/app/**").hasRole(MEMBER.name)
            .simpSubscribeDestMatchers("/user/**").hasRole(MEMBER.name)
            .simpTypeMatchers(MESSAGE, SUBSCRIBE).denyAll()
            .build()
}
