package com.vhontar.core.util

import android.content.Context
import androidx.annotation.StringRes

sealed interface UiText {
    data class DynamicString(val text: String) : UiText
    data class StringResource(@StringRes val resId: Int) : UiText

    fun asString(context: Context): String = when (this) {
        is DynamicString -> text
        is StringResource -> context.getString(resId)
    }
}
