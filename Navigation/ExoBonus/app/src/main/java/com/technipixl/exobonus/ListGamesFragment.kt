package com.technipixl.exobonus

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.technipixl.exobonus.databinding.FragmentGamesBinding
import com.technipixl.exobonus.databinding.FragmentListGamesBinding

class ListGamesFragment : Fragment() {
    private lateinit var binding: FragmentListGamesBinding
    private val args: ListGamesFragmentArgs by navArgs()
    val listOfGames = mutableListOf<Games>()

    init {
        listOfGames.add(Games("Super Mario 64",
        "Jeu d'aventure-plateformes suivant Mario, pour la première fois en 3D, parti à la recherche de la princesse Peach, capturée par le Bowser.",
        TypeOfGames.PLATEFORME))
        listOfGames.add(Games("Portal 2","La partie solo de Portal 2 présente un ensemble de nouveaux personnages, de nouveaux éléments et de nouvelles chambres de test plus vastes.",
        TypeOfGames.PLATEFORME))
        listOfGames.add(Games("Outlast","Survival-horror se déroulant au coeur d'un asile du Colorado, où vous incarnez un journaliste enquêtant sur des évènements étranges s'y tramant...",
        TypeOfGames.HORREUR))
        listOfGames.add(Games("Alien: Isolation",
        "Jeu d’aventure horrifique situé 15 ans après les évènements du premier film dans lequel on incarne Amanda Ripley, partie à la recherche du Nostromo.",
        TypeOfGames.HORREUR))
        listOfGames.add(Games("The Elder Scrolls V: Skyrim",
        "Jeu de rôle suivant les aventures d'un « enfant de dragon » tentant de trouver une explication à ses mystérieux pouvoirs dont il ignorait l'existence.",
        TypeOfGames.RPG))
        listOfGames.add(Games("Fallout 3",
        "30 ans après l'histoire de Fallout 2. Le superviseur de l'abri 101 devient suspicieux quant aux motivations du personnage et ordonne sa mise à mort.",
        TypeOfGames.RPG))
        listOfGames.add(Games("World of Warcraft",
        "Une tension couve le monde ravagé d'Azeroth. Les peuples reconstruisent leurs royaumes. L'arrivée de nouvelles menaces sur le monde est annoncée.",
        TypeOfGames.MMORPG))
        listOfGames.add(Games("Star Wars: The Old Republic",
        "L'histoire se déroule plus de 3500 ans avant la bataille de Yavin. Accompagné d'un autre personnage, réussissez les quêtes et choisissez votre camp.",
        TypeOfGames.MMORPG))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListGamesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listOfGames.filter {
            it.type == args.type
        }.forEach { games ->
            val button = Button(context)
            button.setText(games.name)
            binding.gamesListContainer.addView(button)

            button.setOnClickListener {
                findNavController().navigate(ListGamesFragmentDirections.actionListGamesFragmentToDescriptionFragment(games.name, games.description))
            }
        }
    }

}