package com.github.fgoncalves.features.apod.pub

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apublic.databinding.ApodScreenBinding
import javax.inject.Inject

class ApodScreen : Fragment() {
    @Inject
    lateinit var viewModel: ApodViewModel

    override fun onAttach(context: Context) {
        val apodComponent =
            (context.applicationContext as ApodComponentProvider).provideApodComponent()
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
        val binding = ApodScreenBinding.inflate(inflater)

        binding.viewModel = viewModel

        return binding.root
    }
}
