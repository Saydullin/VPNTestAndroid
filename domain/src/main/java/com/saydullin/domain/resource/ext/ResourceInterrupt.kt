package com.saydullin.domain.resource.ext

import com.saydullin.domain.resource.Resource
import com.saydullin.domain.resource.StatusType
import com.saydullin.domain.resource.exception.ResourceErrorException

fun Resource<Unit>.interruptWith(
    e: Throwable? = null,
    status: String = StatusType.UNKNOWN_ERROR,
    description: String = "null",
) {
    throw ResourceErrorException(e, status, description)
}


