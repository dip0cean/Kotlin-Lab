package com.study.kotlin

import com.study.kotlin.account.application.service.MoneyTransferProperties
import com.study.kotlin.account.domain.Money
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(BuckpalConfigProperties::class)
class BuckpalConfig {

    @Bean
    fun moneyTransferProperties(properties: BuckpalConfigProperties): MoneyTransferProperties =
        MoneyTransferProperties(Money(properties.transferThreshold))
}
