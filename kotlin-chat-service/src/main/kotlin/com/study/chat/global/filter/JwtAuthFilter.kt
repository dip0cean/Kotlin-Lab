package com.study.chat.global.filter

import com.study.chat.global.domain.JwtToken
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtAuthFilter() : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val header = request.getHeader("Authorization")
        if (header.isNullOrBlank() || !header.startsWith("Bearer ")) return filterChain.doFilter(request, response)
        val jwt = JwtToken(header.substring("Bearer ".length))
        if (jwt.isValid()) SecurityContextHolder.getContext().authentication = jwt.getAuthentication()
        filterChain.doFilter(request, response)
    }
}
