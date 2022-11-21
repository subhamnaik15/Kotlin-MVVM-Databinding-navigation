package com.minjee.basicmvvmexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.minjee.basicmvvmexample.R
import com.minjee.basicmvvmexample.databinding.FragmentDetailBinding
import com.minjee.basicmvvmexample.databinding.FragmentMainBinding
import com.minjee.basicmvvmexample.model.MyParcelableDataArgs
import com.minjee.basicmvvmexample.viewmodel.MainViewModel


class DetailFragment: Fragment() {

    // View Binding
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    // Create a viewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // This is needed for view binding
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentTextUpdateObserver()
        val safeArgs: DetailFragmentArgs by navArgs()
        val arg1 = safeArgs.arg1
        val arg2 = safeArgs.arg2 as MyParcelableDataArgs
        val userName=arg2.userName
        val password=arg2.password
        val email=arg2.email

        viewModel.setDataInTextView("User Details : $userName $password $email '\n' $arg1" )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    // Observer is waiting for viewModel to update our UI
    private fun fragmentTextUpdateObserver() {

        viewModel.uiTextLiveData.observe(viewLifecycleOwner, Observer { updatedText ->
            binding.fragmentTextView.text = updatedText
        })
    }
}