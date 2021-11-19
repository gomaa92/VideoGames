package com.gomaa.videogames.features.splash

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gomaa.videogames.R
import com.gomaa.videogames.base.data.local.sharedpref.ISharedPrefsStore
import com.gomaa.videogames.base.data.local.sharedpref.SharedPreferencesConstants
import com.gomaa.videogames.base.presentation.view.fragments.BaseFragment
import com.gomaa.videogames.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {
    private var duration: Long = 3000
    private lateinit var animMoveToTop: Animation

    @Inject
    lateinit var sharedPrefsStore: ISharedPrefsStore
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animMoveToTop = AnimationUtils.loadAnimation(requireContext(), R.anim.move_to_top)
        dataBinding.splashLogo.startAnimation(animMoveToTop)
        loadSplashScreen()
    }

    private fun loadSplashScreen() {
        lifecycleScope.launch(Dispatchers.Main) {
            delay(duration)
            if (!handleNavigation())
                findNavController().navigate(R.id.genresFragment)
            else findNavController().navigate(R.id.gamesFragment)
        }
    }

    private fun handleNavigation(): Boolean {
        return sharedPrefsStore.getBoolean(SharedPreferencesConstants.FIRST_LAUNCH_APP)
    }
}