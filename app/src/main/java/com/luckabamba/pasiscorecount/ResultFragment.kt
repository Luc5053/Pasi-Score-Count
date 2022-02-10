package com.luckabamba.pasiscorecount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ResultFragment : Fragment() {

    var resultadapter = ResultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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


        val fancyrecview = view.findViewById<RecyclerView>(R.id.resulttestRV)

        //fancyrecview.layoutManager = LinearLayoutManager(activity)
        //fancyrecview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        fancyrecview.layoutManager = GridLayoutManager(context,2)
        fancyrecview.adapter = resultadapter


    }

}