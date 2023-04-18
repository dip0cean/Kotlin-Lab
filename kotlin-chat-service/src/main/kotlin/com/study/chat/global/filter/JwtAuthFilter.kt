package com.study.chat.global.filter

import com.study.chat.global.domain.JwtProvider
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtAuthFilter(
    private val jwtProvider: JwtProvider
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val header = request.getHeader("Authorization")
        if (header.isNullOrBlank() || !header.startsWith("Bearer ")) return filterChain.doFilter(request, response)

        val jwt = header.substring("Bearer ".length)
        if (jwtProvider.isValidToken(jwt)) SecurityContextHolder.getContext().authentication =
            jwtProvider.getAuthentication(jwt)
        filterChain.doFilter(request, response)
    }
}
