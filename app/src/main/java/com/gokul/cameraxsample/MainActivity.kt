package com.gokul.cameraxsample

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.gokul.camerax.core.CameraX
import com.gokul.camerax.core.CaptureListener
import com.gokul.camerax.core.Facing

class MainActivity : AppCompatActivity(), CaptureListener{
    lateinit var previewImg: ImageView
    lateinit var captureBtn: Button
    val PERMISSIONS_REQUIRED = arrayOf(Manifest.permission.CAMERA)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        previewImg = findViewById(R.id.previewImg)
        captureBtn = findViewById(R.id.captureBtn)

        captureBtn.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
                triggerCamera()
            }else{
                ActivityCompat.requestPermissions(this, PERMISSIONS_REQUIRED, 1)
            }
        }
    }

    private fun triggerCamera(){
        if (ActivityCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED) {
            CameraX.of(this@MainActivity)
                .attachListener(this@MainActivity)
                .setFacing(Facing.BOTH)
                .start()
        }
    }

    override fun onCaptureFailed(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCaptureSuccess(uri: Uri) {
        previewImg.setImageURI(uri)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (PackageManager.PERMISSION_GRANTED == grantResults.firstOrNull()) {
            triggerCamera()
        } else {
            Toast.makeText(this@MainActivity, "Permission Requires", Toast.LENGTH_SHORT).show()
        }
    }
}