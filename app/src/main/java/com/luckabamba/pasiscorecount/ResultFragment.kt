package com.luckabamba.pasiscorecount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ResultFragment : Fragment() {

    var resultadapter = ResultAdapter()

    var alldata = mutableListOf<PasiData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultadapter.resultfrag = this

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //view.findViewById<TextView>(R.id.resultAreaTV).text = getTotalPASI().toString()
        view.findViewById<TextView>(R.id.totalTextView).text = getTotalPASI().toString()


        val fancyrecview = view.findViewById<RecyclerView>(R.id.resulttestRV)

        //fancyrecview.layoutManager = LinearLayoutManager(activity)
        //fancyrecview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        fancyrecview.layoutManager = GridLayoutManager(context,2)
        fancyrecview.adapter = resultadapter


    }


    fun getTotalPASI() : Float
    {
        var totalpasi = 0.0

        repeat(4) {
            val area = alldata[it].percent
            val redness = alldata[it].redness
            val thickness = alldata[it].thickness
            val scale = alldata[it].scale


            var multiplier = 0.0
            if(it == 0)
            {
                multiplier = 0.1
            }
            if(it == 1)
            {
                multiplier = 0.2
            }
            if(it == 2)
            {
                multiplier = 0.3
            }
            if(it == 3)
            {
                multiplier = 0.4
            }


            val total = (redness + thickness + scale ) * area * multiplier

            totalpasi = totalpasi + total
        }

        return totalpasi.toFloat()
    }
}