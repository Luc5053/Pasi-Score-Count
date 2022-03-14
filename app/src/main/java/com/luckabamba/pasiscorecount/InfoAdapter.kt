package com.luckabamba.pasiscorecount

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class InfoAdapter (internal var context: Context, internal var images: IntArray, internal var conditionType: Array<String>) : BaseAdapter() {

    internal var inflter: LayoutInflater

    init {
        inflter = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {

        val view = inflter.inflate(R.layout.spinner_custom_layout,null)
        val icon = view.findViewById<View>(R.id.spinnerImageView) as ImageView?
        val names = view.findViewById<View>(R.id.spinnerTextView) as TextView?
        icon!!.setImageResource(images[i])
        names!!.text = conditionType[i]
        return view
    }
}