package com.example.diarioroom.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.example.diarioroom.ui.MainActivity
import com.example.diarioroom.R
import com.example.diarioroom.databinding.FragmentAddDiarioBinding
import com.example.diarioroom.model.Diario
import com.example.diarioroom.viewmodel.DiarioViewModel

class AdicionarFragment : Fragment(R.layout.fragment_add_diario), MenuProvider {

    private var _binding: FragmentAddDiarioBinding? = null
    private val binding get() = _binding!!

    private lateinit var diarioViewModel: DiarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflando o layout com ViewBinding
        _binding = FragmentAddDiarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        diarioViewModel = (activity as MainActivity).diarioViewModel

        // Adicionando ação para salvar a nota
        binding.saveButton.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        val noteTitle = binding.addNoteTitle.text.toString().trim()
        val noteDesc = binding.addNoteDesc.text.toString().trim()

        if (noteTitle.isNotEmpty()) {
            val note = Diario(0, noteTitle, noteDesc)
            diarioViewModel.addNote(note)

            Toast.makeText(requireContext(), "Note Saved", Toast.LENGTH_SHORT).show()
            view?.findNavController()?.popBackStack(R.id.homeFragment, false)
        } else {
            Toast.makeText(requireContext(), "Please enter note title", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.menu_add_note, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId) {
            R.id.saveMenu -> {
                saveNote()
                true
            }
            else -> false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
