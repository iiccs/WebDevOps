package com.mucheng.web.devops.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.mucheng.web.devops.R
import com.mucheng.web.devops.data.model.OperatorItem

class OperatorTableAdapter(
    private val context: Context,
    private val operatorItems: List<OperatorItem>
) : RecyclerView.Adapter<OperatorTableAdapter.ViewHolder>() {

    open inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: MaterialTextView = itemView.findViewById(R.id.operatorTitle)
    }

    interface OnInsertTextListener {
        fun onInsertText(text: String)
    }

    private val inflater by lazy { LayoutInflater.from(context) }

    private var onInsertTextListener: OnInsertTextListener? = null

    fun setOnInsertTextListener(onInsertTextListener: OnInsertTextListener) {
        this.onInsertTextListener = onInsertTextListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_operator_table, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val operatorItem = operatorItems[position]
        holder.itemView.setOnClickListener {
            onInsertTextListener?.onInsertText(operatorItem.insertedText)
        }
        holder.title.text = operatorItem.title
    }

    override fun getItemCount(): Int {
        return operatorItems.size
    }

}