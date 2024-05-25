package com.alexkarav.testandroidvacc24.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.alexkarav.testandroidvacc24.R
import com.alexkarav.testandroidvacc24.databinding.FragmentAuthorizationBinding
import com.alexkarav.testandroidvacc24.domain.models.UserLoginInfo
import com.alexkarav.testandroidvacc24.presentation.viewmodels.AuthorizationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthorizationFragment : Fragment() {
    private var binding: FragmentAuthorizationBinding? = null
    private val viewModel: AuthorizationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {  }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(layoutInflater)

        binding?.authButton?.setOnClickListener {
            val userLogin = binding?.emailInput?.text.toString()
            val userPassword = binding?.passwordInput?.text.toString()
            viewModel.authorizeUser(UserLoginInfo(userLogin, userPassword))
        }

        lifecycleScope.launch {
            viewModel.userAuthorized.collectLatest { authorized ->
                if(authorized == false) {
                    Toast.makeText(requireContext(), "Произошла ошибка при авторизации", Toast.LENGTH_LONG).show()
                }
                else {
                    findNavController().navigate(R.id.action_authorizationFragment_to_mainPage)
                }
            }
        }

        return binding?.root!!
    }

    companion object {
        @JvmStatic
        fun newInstance() = AuthorizationFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}