package com.luckabamba.pasiscorecount

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class PasiAdapter() : RecyclerView.Adapter<PasiAdapter.MyViewHolder>() {

    lateinit var pasifrag : PasiFragment

    var nameTitle = listOf<String>("Head and Neck", "Upper extremities", "Trunk", "Lower extremities")

    private var images = intArrayOf(R.drawable.pasi_head, R.drawable.pasi_arms, R.drawable.pasi_trunk,R.drawable.pasi_legs, )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val vh = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.section_layout, parent, false))

        return vh
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.frag = pasifrag
        holder.rownumber = position

        holder.myTitle.text = nameTitle[position]
        holder.picture.setImageResource(images[position])


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




    }

    override fun getItemCount(): Int {

        return nameTitle.size


    }


    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view), AdapterView.OnItemSelectedListener {

        var rownumber = 0
        lateinit var frag : PasiFragment

        var myTitle = view.findViewById<TextView>(R.id.headerTitleTV)
        var picture = view.findViewById<ImageView>(R.id.pasiImageView)

        val spinner: Spinner = view.findViewById<Spinner>(R.id.resultAreaTV)
        val spinner1: Spinner = view.findViewById<Spinner>(R.id.resultRednessTV)
        val spinner2: Spinner = view.findViewById<Spinner>(R.id.resultThicknessTV)
        val spinner3: Spinner = view.findViewById<Spinner>(R.id.resultScaleTV)







        override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {

            Log.i("LUCDEBUG", "ITEM SELECTED")

            if(parent.id == R.id.resultAreaTV)
            {
                frag.alldata[rownumber].percent = pos
            }
            if(parent.id == R.id.resultRednessTV)
            {
                frag.alldata[rownumber].redness = pos
            }
            if(parent.id == R.id.resultThicknessTV)
            {
                frag.alldata[rownumber].thickness = pos
            }
            if(parent.id == R.id.resultScaleTV)
            {
                frag.alldata[rownumber].scale = pos
            }

        }

        override fun onNothingSelected(parent: AdapterView<*>) {
            // Another interface callback
        }

    }


}