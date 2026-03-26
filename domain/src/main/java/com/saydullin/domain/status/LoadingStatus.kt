package com.saydullin.domain.status

import com.saydullin.domain.resource.Resource

sealed class LoadingStatus<out T> {

    data object Loading : LoadingStatus<Nothing>()

    data class Success<T>(val data: T) : LoadingStatus<T>()

    data class Error(val error: Resource.Error<Unit>? = null) : LoadingStatus<Nothing>()

}