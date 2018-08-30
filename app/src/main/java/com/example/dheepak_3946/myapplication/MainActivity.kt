package com.example.dheepak_3946.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    val observableOne : BehaviorSubject<Int> = BehaviorSubject.create()
    val observableTwo : BehaviorSubject<Int> = BehaviorSubject.create()
    val observableThree : BehaviorSubject<Int> = BehaviorSubject.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val threadPool = Executors.newFixedThreadPool(1)
        val scheduler = Schedulers.from(threadPool)
        observableOne.observeOn(scheduler).subscribe{
            Log.e("MainActivity","ObservableOne    $it")
        }

        observableTwo.observeOn(scheduler).subscribe{
            Log.e("MainActivity","ObservableTwo    $it")
        }

        observableThree.observeOn(scheduler).subscribe{
            Log.e("MainActivity","ObservableThree    $it")
        }

        observableOne.onNext(1)
        observableTwo.onNext(2)
        observableThree.onNext(3)
        observableOne.onNext(4)
    }
}
