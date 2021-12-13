package kr.co.korearental.coroutine

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.co.korearental.coroutine.databinding.ActivityMainBinding
import java.net.URL

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.run {
            buttonDownload.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    //Main 디스패처 = Ui
                    progress.visibility = View.VISIBLE // UI부분
                    val url = editUrl.text.toString()
                    val bitmap = withContext(Dispatchers.IO) {
                        loadImage(url) //코드 부분
                    }
                    imagePreview.setImageBitmap(bitmap)
                    progress.visibility = View.GONE
                }
            }
        }
    }

}

suspend fun loadImage(imageUrl:String) : Bitmap {
    val url = URL(imageUrl)
    val stream = url.openStream()
    return BitmapFactory.decodeStream(stream)
}