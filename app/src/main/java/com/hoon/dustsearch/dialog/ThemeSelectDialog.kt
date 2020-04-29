package com.hoon.dustsearch.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import com.hoon.dustsearch.R
import com.hoon.dustsearch.databinding.DialogThemeSelectBinding

class ThemeSelectDialog(context: Context) : Dialog(context),
    View.OnClickListener, RadioGroup.OnCheckedChangeListener{


    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

        when(checkedId) {
            R.id.radio_btn_1 -> {}
            R.id.radio_btn_2 -> {}
            R.id.radio_btn_3 -> {}
            R.id.radio_btn_4 -> {}
            R.id.radio_btn_5 -> {}
        }
    }

    override fun onClick(v: View?) { dismiss() }

    lateinit var dataBinding : DialogThemeSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setCanceledOnTouchOutside(false)
        window?.setBackgroundDrawable(ColorDrawable())
        window?.setDimAmount(0.0f)

        dataBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.dialog_theme_select,
            null,
            false)

        setContentView(dataBinding.root)
        dataBinding.backBtn.setOnClickListener(this)
        dataBinding.radioGroup.setOnCheckedChangeListener(this)
    }
}