package com.example.sharedpreferencesdemo

import android.app.Application
import com.example.sharedpreferencesdemo.model.User
import com.example.sharedpreferencesdemo.module.localModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CoreApplication : Application(){
    companion object{
        lateinit var instance : CoreApplication
            private set
    }

    private val prefUtil : PrefUtil by inject()

    private var user: User? = null

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CoreApplication)
            modules(modules = localModule)
        }

        instance = this
    }


    //for handle save share pref
    fun saveUser(user : User?){
        prefUtil.user = user
        this.user = user
    }

    fun geUser() : User? = user
}