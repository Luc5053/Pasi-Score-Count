package com.luckabamba.pasiscorecount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class PasiData {
    var percent = 0
    var redness = 0
    var thickness = 0
    var scale = 0

}




class PasiFragment : Fragment() {

    var alldata = mutableListOf<PasiData>()

    var pasiadapter = PasiAdapter()
    val rfrag = ResultFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pasiadapter.pasifrag = this

        alldata.add(PasiData())
        alldata.add(PasiData())
        alldata.add(PasiData())
        alldata.add(PasiData())

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

            var resultfrag = ResultFragment()
            resultfrag.alldata = alldata

            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, resultfrag).addToBackStack(null).commit()
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