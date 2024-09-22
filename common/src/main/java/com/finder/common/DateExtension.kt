package com.finder.common

import java.util.Date

fun Date.formatHHMM(): String {
    val hours = if (this.hours < 10) "0${this.hours}" else this.hours
    val minutes = if (this.minutes < 10) "0${this.minutes}" else this.minutes
    return "$hours:$minutes"
}
