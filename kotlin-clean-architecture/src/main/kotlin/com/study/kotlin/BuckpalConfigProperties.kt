package com.study.kotlin

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "buckpal")
class BuckpalConfigProperties {

    val transferThreshold = Long.MAX_VALUE
}
