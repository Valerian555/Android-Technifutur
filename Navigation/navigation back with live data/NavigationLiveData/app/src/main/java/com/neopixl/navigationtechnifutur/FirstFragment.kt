package com.neopixl.navigationtechnifutur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.neopixl.navigationtechnifutur.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    //var qui permet de surveiller les changements de données et de réagir en conséquence
    private var liveData: MutableLiveData<String>? = null

    //Constante utilisée pour définir une clé pour la récupération de données dans le SavedStateHandle.
    companion object {
        const val DETAIL_TEXT = "DETAIL_TEXT"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //permet de savoir l'écran/le fragment sur lequel on se trouve
        val currentBackStackEntry = findNavController().currentBackStackEntry

        val savedStateHandle = currentBackStackEntry?.savedStateHandle

        liveData = savedStateHandle?.getLiveData(DETAIL_TEXT)

        /*observe les changement de liveData, lorsque celle-ci change, la lambda est appelé.
        En résumé, lorsque un changement est appliqué sur liveData, la textView est mise à jour.*/
        liveData?.observe(viewLifecycleOwner) { result ->
            binding.textView.text = result
        }

        binding.detailButton.setOnClickListener {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())
        }
    }

    //on destroy l'Observer pour économiser les données
    override fun onDestroy() {
        liveData?.removeObservers(viewLifecycleOwner)
        super.onDestroy()
    }
}