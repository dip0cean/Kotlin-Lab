package com.study.chat.global.domain

import com.study.chat.member.domain.MemberRole
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@Component
class JwtProvider {
    private val key = Keys.secretKeyFor(SignatureAlgorithm.HS256)
    fun createToken(username: String, role: MemberRole): String {
        val issuedAt = LocalDateTime.now()
        val issuedDate = Date.from(issuedAt.atZone(ZoneId.systemDefault()).toInstant())

        val expiration = issuedAt.plusDays(1)
        val expirationDate = Date.from(expiration.atZone(ZoneId.systemDefault()).toInstant())

        val claims = mapOf("USERNAME" to username, "ROLE" to role.name)

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(issuedDate)
            .setExpiration(expirationDate)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
    }

    fun getAuthentication(token: String): Authentication {
        val claims = getAllClaims(token)
        val username = claims["USERNAME"]
        val authorities = listOf(claims["ROLE"])
            .map { SimpleGrantedAuthority(it as String) }
        return UsernamePasswordAuthenticationToken(username, token, authorities)
    }

    fun isValidToken(token: String?): Boolean = when (token.isNullOrBlank()) {
        true -> false
        false -> getAllClaims(token).expiration.after(Date())
    }

    private fun getAllClaims(token: String): Claims =
        Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body
}
