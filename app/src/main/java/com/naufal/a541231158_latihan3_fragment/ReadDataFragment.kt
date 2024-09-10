package com.naufal.a541231158_latihan3_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufal.a541231158_latihan3_fragment.databinding.FragmentReadDataBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReadDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReadDataFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentReadDataBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReadDataBinding.inflate(inflater, container, false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            if (arguments != null) {
                val myName = arguments?.getString(EXTRA_NAMA)
                tvMyData.text = "Nama Saya : $myName"
            }
            btnKembaliBeranda.setOnClickListener{
                val mIntent = Intent(activity, MainActivity::class.java)
                startActivity(mIntent)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    var nim: Int? = null
    companion object{
        const val EXTRA_NAMA = "extra_nama"
    }
}
