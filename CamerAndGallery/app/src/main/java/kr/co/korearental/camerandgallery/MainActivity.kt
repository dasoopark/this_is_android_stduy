package kr.co.korearental.camerandgallery

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import kr.co.korearental.camerandgallery.databinding.ActivityMainBinding
import java.io.File

class MainActivity : BaseActivity() {

    override fun permissionGranted(requestCode: Int) {
        TODO("Not yet implemented")
    }

    override fun permissionDenied(requestCode: Int) {
        TODO("Not yet implemented")
    }


}
