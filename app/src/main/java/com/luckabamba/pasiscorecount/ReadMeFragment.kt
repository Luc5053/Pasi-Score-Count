package com.luckabamba.pasiscorecount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ReadMeFragment : Fragment() {

    var readMeAdapter = ReadMeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        readMeAdapter.readfrag =this

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*
        view.findViewById<Button>(R.id.readMeBtn).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, readMeFrag).addToBackStack(null).commit()
        }

 */


        val fancyRecview = view.findViewById<RecyclerView>(R.id.readMeRV)

        //fancyrecview.layoutManager = GridLayoutManager(context,2)
        fancyRecview.layoutManager = LinearLayoutManager(context)
        fancyRecview.adapter = readMeAdapter
    }
}