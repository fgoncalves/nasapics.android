package com.github.fgoncalves.features.rover

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.fgoncalves.features.rover.databinding.RoverPhotosScreenBinding
import javax.inject.Inject

class RoverScreen : Fragment() {
    @Inject
    lateinit var viewModel: RoverViewModel

    override fun onAttach(context: Context) {
        val apodComponent =
            (context.applicationContext as RoverComponentProvider).provideRoverComponent()
        apodComponent.inject(this)

        super.onAttach(context)

        lifecycle.addObserver(viewModel)
    }

    override fun onDetach() {
        super.onDetach()
        lifecycle.removeObserver(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = RoverPhotosScreenBinding.inflate(inflater)

        binding.viewModel = viewModel

        return binding.root
    }
}
