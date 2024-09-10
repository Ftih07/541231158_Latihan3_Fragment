package com.naufal.a541231158_latihan3_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufal.a541231158_latihan3_fragment.databinding.FragmentDataBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DataFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentDataBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            btnToSecondFragment.setOnClickListener{
                val namaSaya = inputNamaSaya.text.toString()
                if (namaSaya.isEmpty()) {
                    inputNamaSaya.error = "Nama Tidak Boleh Kosong"
                    return@setOnClickListener
                }
                val mReadDataFragment = ReadDataFragment()
                val mBundle = Bundle()
                mBundle.putString(DataFragment.EXTRA_NAMA, namaSaya)
                mReadDataFragment.arguments = mBundle
                val mFragmentManager = parentFragmentManager
                mFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, mReadDataFragment, ReadDataFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object{
        const val EXTRA_NAMA = "extra_nama"
    }
}
