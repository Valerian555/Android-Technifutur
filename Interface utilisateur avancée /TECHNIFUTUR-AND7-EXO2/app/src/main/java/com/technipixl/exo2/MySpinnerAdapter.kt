package com.technipixl.exo2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.technipixl.exo2.databinding.NonSelectedRowBinding
import com.technipixl.exo2.databinding.SelectionRowBinding
import java.net.BindException

class MySpinnerAdapter(var languages: List<Language>): BaseAdapter() {

    override fun getCount(): Int {
        return languages.size
    }

    override fun getItem(position: Int): Any {
        return languages[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: SelectionRowBinding = if(convertView==null) {
            SelectionRowBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
            } else {
                SelectionRowBinding.bind(convertView)
        }

        binding.languageName.text = languages[position].name
        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: NonSelectedRowBinding = if(convertView==null) {
            NonSelectedRowBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        } else {
            NonSelectedRowBinding.bind(convertView)
        }

        binding.languageName.text = languages[position].name
        return binding.root
    }

}