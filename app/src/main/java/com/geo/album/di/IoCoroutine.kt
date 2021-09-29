package com.geo.album.di

import javax.inject.Qualifier

/**
 * Created by George Thomas on 29/9/21
 */
@Retention(AnnotationRetention.SOURCE)
@Qualifier
@kotlin.annotation.Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION
)
annotation class IoCoroutine