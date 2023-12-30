package com.lifehealth.fitplanner.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lifehealth.fitplanner.R
import com.lifehealth.fitplanner.databinding.ActivityMainBinding
import com.lifehealth.fitplanner.ui.encouragement.EncouragementFragment
import com.lifehealth.fitplanner.ui.mude_note.MoodDiaryFragment
import com.lifehealth.fitplanner.ui.sleep.SleepFragment
import com.lifehealth.fitplanner.ui.sound_of_nature.SoundOfNatureFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation(){
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.encouragement -> {
                    launchFragment(EncouragementFragment())
                    true
                }
                R.id.mood_diary ->{
                    launchFragment(MoodDiaryFragment())
                    true
                }
                R.id.sleep -> {
                    launchFragment(SleepFragment())
                    true
                }
                else ->{
                    launchFragment(SoundOfNatureFragment())
                    true
                }
            }
        }
    }

    private fun launchFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            addToBackStack(null)
            commit()
        }
    }
}