package kr.co.korearental.myservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    inner class MyBinder : Binder() {
        fun getServcie() : MyService {
            return this@MyService
        }
    }
    val binder = MyBinder()

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        Log.d("StartedService", "action=$action")

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("Service", "서비스가 종료되었습니다.")
        super.onDestroy()
    }

    fun serviceMessage() : String{
        return "Hello Activity! I am Service!"
    }

    companion object {
        val ACTION_START = "kr.co.korearental.myservice.START"
        val ACTION_RUN = "kr.co.korearental.myservice.RUN"
        val ACTION_STOP = "kr.co.korearental.myservice.STOP"
    }
}
