package kr.co.korearental.containerrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.korearental.containerrecyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    fun loadDate() : MutableList<Memo>
    {
        val data : MutableList<Memo> = mutableListOf() //뮤터블 컬렉션 선언

        for (no in 1..100)
        {
            val title = "이것이 안드로이드다 ${no}"
            val date = System.currentTimeMillis()
            var memo = Memo(no, title, date)
            data.add(memo)
        }
        return data
    }
}


