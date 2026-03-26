package com.saydullin.domain.resource.exception

import com.saydullin.domain.resource.StatusType

class ResourceErrorException(
    val e: Throwable? = null,
    val status: String = StatusType.UNKNOWN_ERROR,
    val description: String = "",
): Throwable()


