package com.luckabamba.pasiscorecount

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class ReadMeAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    lateinit var readfrag: ReadMeFragment


    var cases = arrayOf("What is Psoriasis Area and Severity Index (PASI)?\n" +
            "A patient’s Psoriasis Area and Severity Index (PASI) is a measure of overall psoriasis severity and coverage. It is a commonly-used measure in clinical trials for psoriasis treatments.\n" +
            "\n" +
            "PASI consists of two major steps:\n" +
            "1) calculating the BSA (Body Surface Area) covered with lesions and\n" +
            "2) assessment of the severity of lesions.\n" +
            "The second step in turn consists of assessing lesions' erythema (redness), induration (thickness) and scaling.\n" +
            "\n" +
            "All calculations are combined into a single score (PASI Score) in the range of 0 (no psoriasis on the body) and up to 72 (the most severe case of psoriasis).\n" +
            "Typically, the PASI would be calculated before, during and after a treatment period in order to determine how well psoriasis responds to the treatment.\n" + "\n" +  "\n" +
            "I would like to thank\n" + "\n" + "\n" + "Dr. Lisa Alenmyr,\n" + "for providing professional assistance for the App's design and functionality.")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val vh = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.read_me, parent, false))

        return vh
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.myTitle.text = cases[position]
    }


    override fun getItemCount(): Int {
        return cases.size

    }


}
class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var myTitle = view.findViewById<TextView>(R.id.infoMe)
}
