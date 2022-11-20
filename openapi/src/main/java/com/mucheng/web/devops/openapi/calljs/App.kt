package com.mucheng.web.devops.openapi.calljs

import android.webkit.JavascriptInterface
import android.webkit.WebView
import kotlinx.coroutines.CoroutineScope

class App(
    private val appCoroutine: CoroutineScope,
    private val webView: WebView
) {

    interface OnTextChangedListener {
        fun onTextChanged(value: String)
    }

    private var language: String = "text"

    private var code: String = ""

    private var changedCode: String = ""

    private var isDark: Boolean = false

    private var onTextChangedListener: OnTextChangedListener? = null

    @JavascriptInterface
    fun notifyTextChanged(value: String) {
        this.changedCode = value
        this.onTextChangedListener?.onTextChanged(value)
    }

    fun setChangedCode(changedCode: String) {
        this.changedCode = changedCode
    }

    fun getChangedCode(): String {
        return changedCode
    }

    fun setLanguage(language: String) {
        this.language = language
    }

    @JavascriptInterface
    fun getLanguage(): String {
        return this.language
    }

    fun setCode(code: String) {
        this.code = code
    }

    @JavascriptInterface
    fun getCode(): String {
        return this.code
    }

    fun setDark(isDark: Boolean) {
        this.isDark = isDark
    }

    @JavascriptInterface
    fun isDark(): Boolean {
        return isDark
    }

    fun setOnTextChangedListener(onTextChangedListener: OnTextChangedListener) {
        this.onTextChangedListener = onTextChangedListener
    }

    fun insert(text: String) {
        webView.loadUrl("javascript:insert(\"${text.replace("\"", "\\\"")}\");")
    }

    fun undo() {
        webView.loadUrl("javascript:undo();")
    }

    fun redo() {
        webView.loadUrl("javascript:redo();")
    }

}