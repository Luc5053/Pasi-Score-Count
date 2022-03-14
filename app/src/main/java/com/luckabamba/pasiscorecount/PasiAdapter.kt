package com.luckabamba.pasiscorecount

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.section_layout.view.*

class PasiAdapter() : RecyclerView.Adapter<PasiAdapter.MyViewHolder>() {

    lateinit var pasifrag : PasiFragment

    var nameTitle = listOf<String>("Head and Neck", "Upper extremities", "Trunk", "Lower extremities")

    private var images = intArrayOf(R.drawable.pasi_head, R.drawable.pasi_arms, R.drawable.pasi_trunk,R.drawable.pasi_legs, )

    var refText = listOf<String>("Enter skin area involved as well as redness, thickness and scale grades for the head and neck.",
    "Enter skin area involved as well as redness, thickness and scale grades for the arms.",
    "Enter skin area involved as well as redness, thickness and scale grades for the trunk. Include axillae and groin.",
    "Enter skin area involved as well as redness, thickness and scale grades for the legs. Include buttocks.")

    internal var conditionType = arrayOf("Erythema", " 0 No redness", " 1 Light red",
        " 2 Red, but not Deep Red", " 3 Very Red", " 4 Extremely Red")
    internal var images1 =
        intArrayOf(R.drawable.ic_baseline_info_24, R.drawable.red_0, R.drawable.red_1, R.drawable.red_2, R.drawable.red_3, R.drawable.red_4)

    internal var conditionType1 = arrayOf("Induration", "0 No thickness", "1 Mild",
        "2 Moderate", "3 Severe", "4 Very severe")

    internal var images2 =
        intArrayOf(R.drawable.ic_baseline_info_24, R.drawable.thick_0, R.drawable.thick_1, R.drawable.thick_2, R.drawable.thick_3, R.drawable.thick_4)


    internal var conditionType2 = arrayOf("Desquamation", "0 No Scale", "1 Mainly fine scale, some of lesion covered",
    "2 Coarser, thin scale, most of lesion covered", "3 Coarser, thick scale, most of lesion covered", "4 Very thick scale, all of lesion covered")
    internal var images3 =
        intArrayOf(R.drawable.ic_baseline_info_24, R.drawable.scale_0, R.drawable.scale_1, R.drawable.scale_2, R.drawable.scale_3, R.drawable.scale_4)


override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val vh = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.section_layout, parent, false))

    return vh
}

override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    holder.frag = pasifrag
    holder.rownumber = position

    holder.myTitle.text = nameTitle[position]
    holder.picture.setImageResource(images[position])
    holder.theRef.text = refText[position]


    holder.spinner.onItemSelectedListener = holder
    ArrayAdapter.createFromResource(
        holder.itemView.context,
        R.array.count_down,
        android.R.layout.simple_spinner_item
    ).also { adapter ->
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        holder.spinner.adapter = adapter
    }

    holder.spinner1.onItemSelectedListener = holder
    ArrayAdapter.createFromResource(
        holder.itemView.context,
        R.array.count_down1,
        android.R.layout.simple_spinner_item
    ).also { adapter ->
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        holder.spinner1.adapter = adapter
    }

    holder.spinner2.onItemSelectedListener = holder
    ArrayAdapter.createFromResource(
        holder.itemView.context,
        R.array.count_down1,
        android.R.layout.simple_spinner_item
    ).also { adapter ->
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        holder.spinner2.adapter = adapter
    }

    holder.spinner3.onItemSelectedListener = holder
    ArrayAdapter.createFromResource(
        holder.itemView.context,
        R.array.count_down1,
        android.R.layout.simple_spinner_item
    ).also { adapter ->
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        holder.spinner3.adapter = adapter
    }

    val customAdapter = InfoAdapter(holder.itemView.context, images1, conditionType)
    holder.spin.adapter = customAdapter
    val customAdapter1 = InfoAdapter(holder.itemView.context, images2, conditionType1)
    holder.spin1.adapter = customAdapter1

    val customAdapter2 = InfoAdapter(holder.itemView.context, images3, conditionType2)
    holder.spin2.adapter = customAdapter2



}

override fun getItemCount(): Int {

    return nameTitle.size

}


class MyViewHolder (view: View) : RecyclerView.ViewHolder(view), AdapterView.OnItemSelectedListener {

    var rownumber = 0
    lateinit var frag : PasiFragment

    var myTitle = view.findViewById<TextView>(R.id.headerTitleTV)
    var picture = view.findViewById<ImageView>(R.id.pasiImageView)
    var theRef = view.findViewById<TextView>(R.id.myRef)

    val spinner: Spinner = view.findViewById<Spinner>(R.id.resultAreaTV)
    val spinner1: Spinner = view.findViewById<Spinner>(R.id.resultRednessTV)
    val spinner2: Spinner = view.findViewById<Spinner>(R.id.resultThicknessTV)
    val spinner3: Spinner = view.findViewById<Spinner>(R.id.resultScaleTV)

    val spin = view.findViewById<View>(R.id.spinnerImgRed) as Spinner
    val spin1 = view.findViewById<View>(R.id.spinnerImgThick) as Spinner
    val spin2 = view.findViewById<View>(R.id.spinnerImgScale) as Spinner

        override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {

            if (parent.id == R.id.resultAreaTV) {
                frag.alldata[rownumber].percent = pos
            }
            if (parent.id == R.id.resultRednessTV) {
                frag.alldata[rownumber].redness = pos
            }
            if (parent.id == R.id.resultThicknessTV) {
                frag.alldata[rownumber].thickness = pos
            }
            if (parent.id == R.id.resultScaleTV) {
                frag.alldata[rownumber].scale = pos
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>) {
            // Another interface callback
        }

    }
}
