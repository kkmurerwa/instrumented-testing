package com.murerwa.instrumentedtesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.murerwa.instrumentedtesting.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    // Create a nullable instance of FragmentFirstBinding
    private var _binding: FragmentFirstBinding? = null

    // Create a variable to get the value of the binding instance
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize binding instance
        _binding = FragmentFirstBinding.bind(view)

        initViews()
    }

    private fun initViews() {
        binding.apply {
            materialButtonAdd.setOnClickListener {
                var currentValue = textViewCounter.text.toString().toInt()

                currentValue += 1

                textViewCounter.text = currentValue.toString()
            }
            materialButtonSubtract.setOnClickListener {
                var currentValue = textViewCounter.text.toString().toInt()

                if (currentValue > 0) {
                    currentValue -= 1

                    textViewCounter.text = currentValue.toString()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        // Destroy binding instance after fragment is destroyed to prevent memory leaks
        _binding = null
    }
}