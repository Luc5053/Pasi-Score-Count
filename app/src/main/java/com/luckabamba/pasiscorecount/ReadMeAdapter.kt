package com.luckabamba.pasiscorecount

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class ReadMeAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    lateinit var readfrag: ReadMeFragment


    var cases = arrayOf("Dermatology Life Quality Index (DLQI)\n" +
            "The Dermatology Life Quality Index or DLQI, developed in 1994, was the first dermatology-specific Quality of Life instrument. \n" +
            "\n" +
            "It is a simple 10-question validated questionnaire which has been used in 33 different skin conditions in 32 countries and is available in 55 languages.\n " +
            "\n" +
            "Its use has been described in over 500 publications including 30 multinational studies.\n " +
            "At present the DLQI is the most frequently used instrument in studies of randomised controlled trials in dermatology.\n" +
            "\n" +
            "What is Psoriasis Area and Severity Index (PASI)\n" +
            "A patient’s Psoriasis Area and Severity Index (PASI) is a measure of overall psoriasis severity and coverage. It is a commonly-used measure in clinical trials for psoriasis treatments.\n" +
            "\n" +
            "PASI consists of two major steps:\n" +
            "1) calculating the BSA (Body Surface Area) covered with lesions and\n" +
            "2) assessment of the severity of lesions.\n" +
            "The second step in turn consists of assessing lesions' erythema (redness), induration (thickness) and scaling.\n" +
            "\n" +
            "All calculations are combined into a single score (PASI Score) in the range of 0 (no psoriasis on the body) and up to 72 (the most severe case of psoriasis).\n" +
            "Typically, the PASI would be calculated before, during and after a treatment period in order to determine how well psoriasis responds to the treatment.\n" + "\n" +  "\n" +
            "I would like to thank\n" + "\n" + "\n" + "Dr. Lisa Karin Alenmyr,\n" + "for providing us with her professional assistance during the all project, and the approval of the final Application's design with functionality.")
    /*
    internal var images1 =
        intArrayOf(R.drawable.ic_baseline_info_24, R.drawable.red_0, R.drawable.red_1, R.drawable.red_2, R.drawable.red_3, R.drawable.red_4)
    internal var cases1 = arrayOf("Grading(Induration)", "0 No thickness", "1 Mild",
        "2 Moderate", "3 Severe", "4 Very severe")

    internal var images2 =
        intArrayOf(R.drawable.ic_baseline_info_24, R.drawable.thick_0, R.drawable.thick_1, R.drawable.thick_2, R.drawable.thick_3, R.drawable.thick_4)


    internal var cases2 = arrayOf("Grading Scales", "0 No Scale", "1 Mainly fine scale, some of lesion covered",
        "2 Coarser, thin scale, most of lesion covered", "3 Coarser, thick scale, most of lesion covered, rough", "4 Very thick scale, all of lesion covered, very rough")
    internal var images3 =
        intArrayOf(R.drawable.ic_baseline_info_24, R.drawable.scale_0, R.drawable.scale_1, R.drawable.scale_2, R.drawable.scale_3, R.drawable.scale_4)

     */



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val vh = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.read_me, parent, false))

        return vh
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.myTitle.text = cases[position]
        //holder.picture.setImageResource(images1[position])
/*
        holder.myTitle.text = cases1[position]
        holder.picture.setImageResource(images2[position])

        holder.myTitle.text = cases2[position]
        holder.picture.setImageResource(images2[position])

 */

    }


    override fun getItemCount(): Int {
        return cases.size

    }


}
class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var myTitle = view.findViewById<TextView>(R.id.infoMe)
    //var picture = view.findViewById<ImageView>(R.id.spinnerImageView)



}
