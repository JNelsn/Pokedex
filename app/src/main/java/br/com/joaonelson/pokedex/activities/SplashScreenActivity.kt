package br.com.joaonelson.pokedex.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.joaonelson.pokedex.R


@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this,PokemonListActivity::class.java)
            startActivity(intent)
            finish()
        },3000)


    }
}