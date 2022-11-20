package com.mucheng.web.devops.data.model

open class OperatorItem(var title: String, var insertedText: String) {

    constructor(title: String) : this(title, title)

    override fun toString(): String {
        return "OperatorItem(title=$title, insertedText=$insertedText)"
    }

}