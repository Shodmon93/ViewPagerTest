package com.example.progressbartest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.progressbartest.databinding.FragmentBlankOneBinding
import com.genius.multiprogressbar.MultiProgressBar

class BlankFragmentOne : Fragment(), MultiProgressBar.ProgressStepChangeListener, MultiProgressBar.ProgressFinishListener {

    private lateinit var binding: FragmentBlankOneBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlankOneBinding.inflate(layoutInflater)
        binding.storyProgressBar.start()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.storyProgressBar.setSingleDisplayTime(3f)
        binding.storyProgressBar.setProgressStepsCount(4)
        binding.storyProgressBar.setListener(this)
        binding.storyProgressBar.setFinishListener(this)


        binding.rightView.setOnClickListener {
            binding.storyProgressBar.next()
            binding.storyProgressBar.start()
        }
        binding.leftView.setOnClickListener {
            binding.storyProgressBar.previous()
            binding.storyProgressBar.start()
        }
    }

    override fun onProgressFinished() {
        val pager = activity?.findViewById<ViewPager2>(R.id.vpager)
        pager?.currentItem = pager?.currentItem!! +2
    }

    override fun onProgressStepChange(newStep: Int) {
        Glide.with(this)
            .load(R.drawable.ic_launcher_background)
            .into(binding.image)
    }

    override fun onStart() {
        binding.storyProgressBar.start()
        super.onStart()
    }


}