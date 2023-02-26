package com.study.kotlin.account.application.service

import com.study.kotlin.account.domain.Money

class ThresholdExceededException(
    threshold: Money,
    actual: Money
) : RuntimeException("Maximum threshold for transferring money exceeded: tried to transfer $actual but threshold is $threshold!")
