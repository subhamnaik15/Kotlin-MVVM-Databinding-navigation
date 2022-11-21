package com.minjee.basicmvvmexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.minjee.basicmvvmexample.databinding.FragmentMainBinding
import com.minjee.basicmvvmexample.model.MyParcelableDataArgs
import com.minjee.basicmvvmexample.viewmodel.MainViewModel
import java.util.*

/*
 *      MainFragment
 *      - shows the UI
 *      - listens to viewModel for updates on UI
 */
class MainFragment: Fragment() {

    // View Binding
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    // Create a viewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // This is needed for view binding
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Setup the button in our fragment to call getUpdatedText method in viewModel
    private fun setupClickListeners() {
        binding.fragmentButton.setOnClickListener {

            val email = "subnaik15@gmail.com"

            val arg1 = "Fragment : 1"
            val arg2= MyParcelableDataArgs(email)
            arg2.userName= viewModel.userName.value?:""
            arg2.password= viewModel.password.value?:0
            val action =
                MainFragmentDirections.actionMyHomeFragmentToMySecondFragment(
                    arg1,
                    arg2
                )

            findNavController().navigate(action)

        }
    }
}