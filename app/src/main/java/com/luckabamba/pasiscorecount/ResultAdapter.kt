package com.luckabamba.pasiscorecount

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class ResultAdapter(): RecyclerView.Adapter<ResultAdapter.MyViewHolder>() {

    lateinit var resultfrag : ResultFragment

    var nameTitle = listOf<String>("Head and Neck", "Upper extremities", "Trunk", "Lower extremities")

    private var images = intArrayOf(R.drawable.pasi_gray_red_smaller_head, R.drawable.pasi_gray_red_smaller_arms, R.drawable.pasi_gray_red_smaller_trunk,R.drawable.pasi_gray_red_smaller_legs, )




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val vh = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.result_section_layout, parent, false))

        return vh
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val countdown = resultfrag.requireContext().resources.getStringArray(R.array.count_down).toList()

        holder.myTitle.text = nameTitle[position]
        holder.picture.setImageResource(images[position])
        //holder.areaResult.text = countdown[resultfrag.alldata[position].percent]
        holder.areaResult.text = resultfrag.alldata[position].percent.toString()
        holder.rednessResult.text = resultfrag.alldata[position].redness.toString()
        holder.thicknessResult.text = resultfrag.alldata[position].thickness.toString()
        holder.scaleResult.text = resultfrag.alldata[position].scale.toString()

        holder.totalResult.text = nameTitle[position]

        val area = resultfrag.alldata[position].percent
        val redness = resultfrag.alldata[position].redness
        val thickness = resultfrag.alldata[position].thickness
        val scale = resultfrag.alldata[position].scale


        var multiplier = 0.0
        if(position == 0)
        {
            multiplier = 0.1
        }
        if(position == 1)
        {
            multiplier = 0.2
        }
        if(position == 2)
        {
            multiplier = 0.3
        }
        if(position == 3)
        {
            multiplier = 0.4
        }


        val total = (redness + thickness + scale ) * area * multiplier

         holder.totalResult.text = total.toFloat().toString()

        //holder.areaResult.setOnClickListener {
            //holder.spinner.onItemSelectedListener = holder
        //}

    }



    override fun getItemCount(): Int {
        return nameTitle.size
    }


    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view), AdapterView.OnItemSelectedListener {


        var myTitle = view.findViewById<TextView>(R.id.headerTitleTV)
        var picture = view.findViewById<ImageView>(R.id.pasiImageView)

        val areaResult: TextView = view.findViewById<TextView>(R.id.resultAreaTV)
        val rednessResult: TextView = view.findViewById<TextView>(R.id.resultRednessTV)
        val thicknessResult: TextView = view.findViewById<TextView>(R.id.resultThicknessTV)
        val scaleResult: TextView = view.findViewById<TextView>(R.id.resultScaleTV)
        val totalResult: TextView = view.findViewById<TextView>(R.id.totalTV)





        override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {

        }

        override fun onNothingSelected(parent: AdapterView<*>) {
            // Another interface callback
        }

    }

}