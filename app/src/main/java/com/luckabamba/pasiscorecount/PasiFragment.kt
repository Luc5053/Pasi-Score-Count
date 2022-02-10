package com.luckabamba.pasiscorecount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PasiFragment : Fragment() {



    var pasiadapter = PasiAdapter()
    val rfrag = ResultFragment()

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
        return inflater.inflate(R.layout.fragment_pasi, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.scoreResultatbtn).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, ResultFragment() ).commit()
           // var pfrag = ResultFragment()

            //var fragTransact = requireActivity().supportFragmentManager.beginTransaction()
            /*
            //fragTransact.setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
            fragTransact.add(R.id.fragmentContainerView, pfrag)
            //fragTransact.addToBackStack(null)
            fragTransact.commit()

 */
        }


        val fancyRecview = view.findViewById<RecyclerView>(R.id.pastestRV)

        fancyRecview.layoutManager = LinearLayoutManager(context)
        fancyRecview.adapter = pasiadapter








    }

}