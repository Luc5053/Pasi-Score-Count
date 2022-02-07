package com.luckabamba.pasiscorecount

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Collections.list

class MainActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener {

    val areaValues = arrayOf(0, 1 ,2, 3, 4, 5, 6)

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
       val area =  areaValues[pos]
        Toast.makeText(this, "Area: $area", Toast.LENGTH_SHORT).show()

    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }

    var thecount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameTitle = listOf("Head and Neck", "Upper extremities", "Trunk", "Lower extremities")

        val myPicture: Drawable? = ContextCompat.getDrawable(this, R.drawable.pasi_head)
        val myPicture1: Drawable? = ContextCompat.getDrawable(this, R.drawable.pasi_arms)
        val myPicture2: Drawable? = ContextCompat.getDrawable(this, R.drawable.pasi_trunk)
        val myPicture3: Drawable? = ContextCompat.getDrawable(this, R.drawable.pasi_legs)

        populateSections(findViewById(R.id.upperBody), nameTitle[0], myPicture)
        populateSections(findViewById(R.id.topBody), nameTitle[1], myPicture1)
        populateSections(findViewById(R.id.middleBody), nameTitle[2], myPicture2)
        populateSections(findViewById(R.id.lowerBody), nameTitle[3], myPicture3)

    }

    private fun populateSections(container: LinearLayout, title: String, image: Drawable?) {
        container.findViewById<TextView>(R.id.headerTitleTV).text = title
        container.findViewById<ImageView>(R.id.bodyImageView).setImageDrawable(image)
        spinnerArea(container)
        spinnerRedness(container)
        spinnerThickness(container)
        spinnerScale(container)
    }

    private fun spinnerArea(container: LinearLayout) {

        val spinner: Spinner = container.findViewById<Spinner>(R.id.spinner_area)
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.count_down,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }

    private fun spinnerRedness(container: LinearLayout) {

        val spinner: Spinner = container.findViewById<Spinner>(R.id.spinner_redness)
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.count_down1,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

    }

    private fun spinnerThickness(container: LinearLayout) {

        val spinner: Spinner = container.findViewById<Spinner>(R.id.spinner_thickness)
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.count_down1,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


    }

    private fun spinnerScale(container: LinearLayout) {

        val spinner: Spinner = container.findViewById<Spinner>(R.id.spinner_scale)
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.count_down1,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


    }
}

