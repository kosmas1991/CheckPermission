package gr.techzombie.checkpermission

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myCheckPermission()

    }

    var ACCESSCAMERA=123
    fun myCheckPermission(){
        if(Build.VERSION.SDK_INT>=23){
            if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
                requestPermissions(arrayOf(android.Manifest.permission.CAMERA),ACCESSCAMERA)
                return
            }
        }
        getCameraAccess()
    }
    fun getCameraAccess(){
        Toast.makeText(this,"ACCESS  GRANTED",Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            ACCESSCAMERA-> {
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED)
                    getCameraAccess()
                else{
                    Toast.makeText(this,"ACCESS not GRANTED",Toast.LENGTH_SHORT).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}
