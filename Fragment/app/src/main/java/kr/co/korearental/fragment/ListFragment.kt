package kr.co.korearental.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.korearental.fragment.databinding.FragmentListBinding

class ListFragment : Fragment() {
    var mainActivity:MainActivity? = null

    lateinit var binding:FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener { mainActivity?.goDetail() }

        binding.textTitle.text = arguments?.getString("key1")
        binding.textValue.text = "${arguments?.getInt("key2")}" //정수형은 문자열 템플릿을 이용해서 값을 입력해야 함

        return binding.root
    }

    fun setValue(value:String) {
        binding.textFromActivity.text = value
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }


}