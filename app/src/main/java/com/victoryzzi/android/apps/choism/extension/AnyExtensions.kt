package com.victoryzzi.android.apps.choism.extension

import android.util.Log

fun tag(): String {
    val trace = Thread.currentThread().stackTrace[4]
    val fileName = trace.fileName
    val classPath = trace.className
    val className = classPath.substring(classPath.lastIndexOf(".") + 1)
    val methodName = trace.methodName
    val lineNumber = trace.lineNumber
    return "$className.$methodName($fileName:$lineNumber)"
}

fun Any.loge(msg: String) {
    Log.e(tag(), msg)
}
