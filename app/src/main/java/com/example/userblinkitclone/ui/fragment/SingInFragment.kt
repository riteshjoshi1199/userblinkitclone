package com.example.userblinkitclone.ui.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.userblinkitclone.R
import com.example.userblinkitclone.databinding.FragmentSingInBinding

class SingInFragment: Fragment() {
    private lateinit var binding: FragmentSingInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSingInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getUserNumber()
    }

    private fun getUserNumber() {
        binding.etUserNumber.doAfterTextChanged {txt->
            Log.d(TAG, "getUserNumber: $txt")
            if (txt?.toString()?.length == 10) {
                binding.btncontinue.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green))
            } else {
                binding.btncontinue.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gray))
            }
        }
    }

    private fun setStatusBarColor() {
        activity?.window?.apply {
            statusBarColor = ContextCompat.getColor(requireContext(), R.color.yellow)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    companion object{
        private const val TAG = "SingInFragment"
    }
}