package com.example.drinker.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.drinker.R
import com.example.drinker.databinding.FragmentHomeBinding
import com.example.drinker.model.GameDomainModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: HomeAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        //Koin
        //val homeViewModel: HomeViewModel by viewModel<HomeViewModel>()
        //val homeViewModel = get<HomeViewModel>()

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val games = listOf(
            GameDomainModel(
                id = 1,
                name = "Petit Jésus",
                dicesRequired = false,
                cardsRequired = true,
                time = 3,
                upVotes = 0,
                downVotes = 0,
                isFavorite = false,
            ),
            GameDomainModel(
                id = 2,
                name = "Biskit",
                dicesRequired = true,
                cardsRequired = false,
                time = 3,
                upVotes = 0,
                downVotes = 0,
                isFavorite = false,
            ),
            GameDomainModel(
                id = 3,
                name = "PMU",
                dicesRequired = false,
                cardsRequired = true,
                time = 1,
                upVotes = 0,
                downVotes = 0,
                isFavorite = false,
            ),
            GameDomainModel(
                id = 4,
                name = "VROUM",
                dicesRequired = false,
                cardsRequired = false,
                time = 1,
                upVotes = 0,
                downVotes = 0,
                isFavorite = false,
            ),
            GameDomainModel(
                id = 5,
                name = "Parcours",
                dicesRequired = true,
                cardsRequired = true,
                time = 2,
                upVotes = 0,
                downVotes = 0,
                isFavorite = false,
            ),
        )

        adapter = HomeAdapter(games)

        binding.rvGames.adapter = adapter
        binding.rvGames.layoutManager = LinearLayoutManager(context)

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_notificationsFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}