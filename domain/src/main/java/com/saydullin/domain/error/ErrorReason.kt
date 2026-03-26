package com.saydullin.domain.error

sealed class ErrorReason {

    object NoConnection: ErrorReason()

    object Unknown: ErrorReason()

    // Что-то еще будет ...

}