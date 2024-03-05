package com.example.havagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.example.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var amb: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        setSupportActionBar(amb.mainTb)
        supportActionBar?.title = getString(R.string.app_name)

        with(amb){
            celularCb.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    celularLl.visibility = View.VISIBLE
                }else{
                    celularLl.visibility = View.GONE
                }
            }

            formSp.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if(position == 0 || position == 1){
                        anoForm.visibility = View.VISIBLE
                    }else if (position == 2 || position == 3){
                        anoForm.visibility = View.GONE
                        anoConclusao.visibility = View.VISIBLE
                    }else if (position == 4 || position == 5){
                        anoForm.visibility = View.GONE
                        anoConclusao.visibility = View.GONE
                        pesquisaLl.visibility = View.VISIBLE
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

        }
    }
}