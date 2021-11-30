package kr.co.korearental.containerrecyclerview

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.korearental.containerrecyclerview.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class CustomAdapter : RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<Memo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
       val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo) //따로 구현한 함수
    }

    override fun getItemCount(): Int {
        return listData.size
    }


}

class Holder(val binding : ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) //ItemRecycler => item_recycler 레이아웃 이름임

{
    fun setMemo(memo : Memo)
    {
     binding.textNo.text = "${memo.no}"
     binding.textTitle.text = memo.title
     var sdf = SimpleDateFormat("yyyy/MM/dd")
     var formattedDate = sdf.format(memo.timestamp)
     binding.textDate.text = formattedDate
    }

}

