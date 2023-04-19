package com.study.chat.global.domain

import com.study.chat.member.domain.MemberRole
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import javax.crypto.SecretKey

class JwtToken {

    val value: String?
    private val key: SecretKey =
        Keys.hmacShaKeyFor(Decoders.BASE64.decode("77848c3af62f4699e4d1ede93555864c2306bb49f0554e2fa9aaad9225d582ca4d17bca04df0459b4f170c462b92d48708a1e73090823bf7275e9580d52e6347"))

    constructor(username: String, role: MemberRole) {
        val issuedAt = LocalDateTime.now()
        val issuedDate = Date.from(issuedAt.atZone(ZoneId.systemDefault()).toInstant())

        val expiration = issuedAt.plusDays(1)
        val expirationDate = Date.from(expiration.atZone(ZoneId.systemDefault()).toInstant())

        val claims = mapOf("USERNAME" to username, "ROLE" to role.name)

        val token = Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(issuedDate)
            .setExpiration(expirationDate)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
        this.value = token
    }

    constructor(token: String?) {
        this.value = token
    }

    fun getAuthentication(): Authentication {
        val claims = getAllClaims()
        val username = claims["USERNAME"]
        val authorities = listOf(claims["ROLE"])
            .map { SimpleGrantedAuthority(it as String) }
        return UsernamePasswordAuthenticationToken(username, value, authorities)
    }

    fun isValid(): Boolean = when (value.isNullOrBlank()) {
        true -> false
        false -> getAllClaims().expiration.after(Date())
    }

    private fun getAllClaims(): Claims =
        Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(value)
            .body
}
