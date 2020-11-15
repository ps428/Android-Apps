package com.example.camerafilter

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.*
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import androidx.core.graphics.createBitmap
import java.util.jar.Manifest

class CaptureImageOrSaveIt : AppCompatActivity() {

    val saveImage = findViewById<Button>(R.id.saveImage)
    val captureImage = findViewById<Button>(R.id.captureImage)
    val image = findViewById<ImageView>(R.id.imageView)
    val CAMERA_ACCESS_CODE = 101
    val CAMERA_REQUEST_CODE = 110

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capture_image_or_save_it)

        saveImage.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //Your code here
                val toastSaved = Toast.makeText(applicationContext, "Saved Image Successfully", Toast.LENGTH_LONG)
                toastSaved.show()
            }})

        captureImage.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {
                //Your code here
                askForCameraPermission()
            }})

    }

    fun askForCameraPermission(){
      /* @Suppress("DEPRECATED_IDENTITY_EQUALS")
        if(ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CAMERA)!==PackageManager.PERMISSION_GRANTED){

             ActivityCompat.requestPermissions(this, String[] {Manifest.permission.CAMERA}, CAMERA_ACCESS_CODE )
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        }
        else {
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        }*/
    }
    }

    fun openCamera(){

        val  intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(data!=null){

            val bitmap = data.extras.
            bitmap = convertToGreyScale(bitmap)
            image.setImageBitmap(bitmap)

        }
    }*/

    fun convertToGreyScale (originalBitmap: Bitmap): Bitmap{

        val height = originalBitmap.height
        val width = originalBitmap.width

        val newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        val c = Canvas(newBitmap)
        val paint = Paint()
        val cm = ColorMatrix()
        cm.setSaturation(0.0F)

        val f = ColorMatrixColorFilter(cm)
        paint.setColorFilter(f)
        c.drawBitmap(originalBitmap,0F,0F,paint)

        return newBitmap
    }
