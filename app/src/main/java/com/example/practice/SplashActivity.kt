package  com.example.practice
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash);
        supportActionBar?.hide()
        val hander = Handler(Looper.getMainLooper());
        hander.postDelayed({
            val intent:Intent = Intent(this,MainActivity::class.java);
            startActivity(intent);
            finish();
        },3000);
    }
}